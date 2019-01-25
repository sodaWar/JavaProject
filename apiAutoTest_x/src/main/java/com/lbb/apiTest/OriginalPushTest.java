package com.lbb.apiTest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lbb.model.NameForApi;
import com.lbb.model.TBlacklistModel;
import com.lbb.model.TGreyListModel;
import com.lbb.model.TWhiteListModel;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class OriginalPushTest {

    private String url = ReadConfigUtil.getUrl(NameForApi.NEW_OWAPI_ORIGINAL_PUSH, "test");
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private String mobile = "13854212367";


    @Test
    public void addTestData() {

        Map<String, String> map = new HashMap();
        map.put("orgId", "1");
        map.put("orgName", "51");
        map.put("mobile", mobile);
        //添加灰名单
        MysqlUtil.getSqlSession().insert("addGreyByParam", map);

        //添加白名单
        MysqlUtil.getSqlSession().insert("addWhiteByParam", map);
        MysqlUtil.getSqlSession().commit();

        //验证是否添加成功
        TGreyListModel tGreyListModel = MysqlUtil.getSqlSession().selectOne("findGreyByParam", map);
        TWhiteListModel tWhiteListModel = MysqlUtil.getSqlSession().selectOne("findWhiteByParam", map);
        if (tGreyListModel != null && tWhiteListModel != null) {
            Assert.assertEquals(tGreyListModel.getMobile(), mobile);
            Assert.assertEquals(tWhiteListModel.getMobile(), mobile);
            logger.info("------------添加灰名单和白名单数据成功");
        } else {
            logger.error("------------添加灰名单和白名单数据失败，请检查");
        }
    }


    @Test
    public void originalPushTest() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("orgId", "新颜");
        jsonObject.put("uid", "360926197302164710");
        jsonObject.put("qtype", "2");
        jsonObject.put("mobile", mobile);
        jsonObject.put("name", "测试Push");

        String entity = HttpDoRequestUtil.doPost(url, jsonObject);
        logger.info("接口响应数据---------------------" + entity);


        Map<String, String> map = new HashMap();
        map.put("orgId", "");
        map.put("orgName", "");
        map.put("mobile", mobile);
        //查找黑名单数据是否入库
        TBlacklistModel tBlacklistModel = MysqlUtil.getSqlSession().selectOne("findBckByParam", map);
        if (tBlacklistModel != null) {

            Assert.assertEquals(tBlacklistModel.getMobile(), mobile);
        } else {
            logger.error("----------------查询黑名单数据为空请检查");
        }

    }

    @Test(dependsOnMethods = "originalPushTest", description = "验证接口调用成功后，是否清洗了黑名单和白名单")
    public void success() {
        //查询白名单
        TWhiteListModel tWhiteListModel = MysqlUtil.getSqlSession().selectOne("findWByMobile", mobile);
        //查询灰名单
        TGreyListModel tGreyListModel = MysqlUtil.getSqlSession().selectOne("findTByMobile", mobile);

        if (tWhiteListModel== null && tGreyListModel == null) {

            Assert.assertNull(tWhiteListModel);
            Assert.assertNull(tGreyListModel);
            logger.info("白和灰名单清除成功");
        } else {
            logger.error("白名单和灰名单清除失败----------");
        }


    }

    //本机构上传逾期数据，会更新黑名单的还款状态。其他机构不会更新
    @Test
    public void yuqi() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("orgId", "51闪电购");
        jsonObject.put("uid", "360926197302164710");
        jsonObject.put("qtype", "1");
        jsonObject.put("mobile", "13843109180");
        jsonObject.put("name", "测试Push");
        jsonObject.put("data", "{\"orderId\": \"\",\"timeoutDay\":\"5\",\"isSelf\":\"1\",\"status\":\"8\"}");

        String entity = HttpDoRequestUtil.doPost(url, jsonObject);
        logger.info("接口响应数据---------------------" + entity);

    }

    //非本构建上传逾期数据，不会清洗黑名单还款状态
    @Test
    public void yuqTwo() throws IOException {

        HttpClient httpClient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost(url);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("orgId", "测试平台");
        jsonObject.put("uid", "360926197302164710");
        jsonObject.put("qtype", "1");
        jsonObject.put("mobile", "13843109180");
        jsonObject.put("name", "测试Push");
        jsonObject.put("data", "{\"orderId\": \"\",\"timeoutDay\":\"5\",\"isSelf\":\"1\",\"status\":\"8\"}");

        Date date = new Date();
        String reqTime = String.valueOf(date.getTime() / 1000);

        StringBuilder builder = new StringBuilder("lbbcs");
        builder.append(reqTime);
        builder.append(jsonObject);
        String res = DigestUtils.md5Hex(DigestUtils.md5Hex(builder.toString()));


        Header[] headers = new Header[4];
        headers[0] = new BasicHeader("accessKey", "lbb");
        headers[1] = new BasicHeader("reqTime", reqTime);
        headers[2] = new BasicHeader("sign", res);
        headers[3] = new BasicHeader("Content-Type", "application/json");
        StringEntity entity = new StringEntity(jsonObject.toJSONString(), "utf-8");
        httpPost.setEntity(entity);
        httpPost.setHeaders(headers);

        HttpResponse httpResponse = httpClient.execute(httpPost);

        HttpEntity entity2 = httpResponse.getEntity();
        String entity1 = EntityUtils.toString(entity2);

        JSONObject result = JSON.parseObject(entity1);

        String code = result.getString("code");
        if (code.equals("1000000")) {

            logger.info("接口请求成功响应数据是：" + result);
        } else {
            logger.error("接口请求失败响应数据是：" + result);
        }

    }
}
