package com.lbb.apiTest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Date;

//接口正常调用，但是不会涉及到数据清洗操作，也不会涉及黑白灰名单mysql表的增删改查操作
public class PushBlackList {
    private String url = "http://47.98.155.93:8081/owapi/original/push/blackList";
    private String mobile = "18626876675";
    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());


    @Test
    public void pushBlackList() throws IOException {

        HttpClient httpClient= HttpClients.createDefault();

        HttpPost httpPost=new HttpPost(url);


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("orgId", "测试平台");
        jsonObject.put("uid", "420555232212222");
        jsonObject.put("qtype", "2");
        jsonObject.put("mobile", mobile);
        jsonObject.put("name", "李彬彬测试");
        jsonObject.put("data", "{\"label\": \"测试平台\",\"timeoutDay\": 11,\"detail\":{\"orgId\":\"测试平台\",\"uid\":\"420555232212222\",\"mobile\":\"18626876675\",\"name\":\"李彬彬测试\",\"data\":\"dasd\"}}");


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



    }










}
