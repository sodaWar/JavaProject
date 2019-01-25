package com.lbb.apiTest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lbb.model.NameForApi;
import com.lbb.utils.HttpDoRequestUtil;
import com.lbb.utils.MysqlUtil;
import com.lbb.utils.ReadConfigUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;



//验证本机构能够查询所有的数据，其他机构，只能查询timeout_day>0的数据
public class CreditBlackListTest {
    //黑名单数据下行接口（读mysql）
    private String url = ReadConfigUtil.getUrl(NameForApi.NEW_ORAPI_CREDIT_BLACKLIST, "test");
    private String mobile = "13843109180";
    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test(description = "添加黑名单数据")
    public void addBlack() {
        MysqlUtil.getSqlSession().insert("addBlack", "-1");
        MysqlUtil.getSqlSession().insert("addBlack", "13");
        MysqlUtil.getSqlSession().insert("addBlack", "12");
        MysqlUtil.getSqlSession().commit();

    }


    @Test(dependsOnMethods = "addBlack",description = "51闪电购机构调用此接口")
    public void creditBlackListTest() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("category", "1");
        jsonObject.put("mobile", mobile);
        jsonObject.put("label", "");
        jsonObject.put("timeoutDay", "");
        jsonObject.put("userName", "");
        jsonObject.put("state", "");

        String entity = HttpDoRequestUtil.doPost(url, jsonObject);

        JSONObject result = JSON.parseObject(entity);
        String code = result.getString("code");

        if (code.equals("1000000")) {

            logger.info("接口请求成功响应数据是：" + result);
        } else {
            logger.error("接口请求失败响应数据是：" + result);
        }

        //判断内部机构查询时，是否查询了全部数据
        JSONArray array = result.getJSONArray("data");
        for (Object item : array) {
            int timeoutDay = Integer.parseInt(((JSONObject) item).getString("timeoutDay"));
            if (timeoutDay < 0) {
                logger.info("查询到timeoutDay<0的数据-------------");
            }
            else {
                logger.info("查询到timeoutDay>0的数据-------------");

            }

        }

    }

    //非本部机构
    @Test(dependsOnMethods = "addBlack")
    public void doPosts() throws IOException {

        HttpClient httpClient= HttpClients.createDefault();

        HttpPost httpPost=new HttpPost(url);


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("category", "1");
        jsonObject.put("mobile", mobile);
        jsonObject.put("label", "");
        jsonObject.put("timeoutDay", "");
        jsonObject.put("userName", "");
        jsonObject.put("state", "");

        Date date = new Date();
        String reqTime = String.valueOf(date.getTime() / 1000);

        StringBuilder builder = new StringBuilder("lbbcs");
        builder.append(reqTime);
        builder.append(jsonObject);
        String res = DigestUtils.md5Hex(DigestUtils.md5Hex(builder.toString()));



        Header[]headers=new Header[4];
        headers[0]=new BasicHeader("accessKey","lbb");
        headers[1]=new BasicHeader("reqTime",reqTime);
        headers[2]=new BasicHeader("sign",res);
        headers[3]=new BasicHeader("Content-Type","application/json");
        StringEntity entity=new StringEntity(jsonObject.toJSONString(),"utf-8");
        httpPost.setEntity(entity);
        httpPost.setHeaders(headers);

        HttpResponse httpResponse=httpClient.execute(httpPost);

        HttpEntity entity2=httpResponse.getEntity();
        String entity1 =EntityUtils.toString(entity2);

        JSONObject result = JSON.parseObject(entity1);



        String code=result.getString("code");
        if (code.equals("1000000")) {

            logger.info("接口请求成功响应数据是：" + result);
        } else {
            logger.error("接口请求失败响应数据是：" + result);
        }

        JSONArray array = result.getJSONArray("data");


        Collections.sort(array, (o1, o2) -> {
            JSONObject jsonObject1 = (JSONObject) o1;
            JSONObject jsonObject2 = (JSONObject) o2;
            return jsonObject1.getString("timeoutDay").compareTo(jsonObject2.getString("timeoutDay"));
        });
        JSONObject object = array.getJSONObject(0);
        Integer timeOutDay = object.getInteger("timeoutDay");
        if (timeOutDay < 0) {
            logger.info("查询到timeoutDay<0的数据-------------");
        }
        else {
            logger.info("查询到timeoutDay>0 的数据-------------");

        }


    }


}


