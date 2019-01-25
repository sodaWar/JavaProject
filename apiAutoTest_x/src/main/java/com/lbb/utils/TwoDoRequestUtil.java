package com.lbb.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Date;

//发送http请求类
public class TwoDoRequestUtil {

    //post请求
    public static String doPost(String url, JSONObject param,String accessSecret ,String accessKey)  {

        CloseableHttpClient httpClient= HttpClients.createDefault();
        HttpPost httpPost=new HttpPost(url);

        //把参数转换成entity
        StringEntity entity=new StringEntity(param.toJSONString(),"utf-8");
        //放入参数
        httpPost.setEntity(entity);

        Date date = new Date();
        String reqTime = String.valueOf(date.getTime() / 1000);
        StringBuilder builder = new StringBuilder(accessSecret );
        builder.append(reqTime);
        builder.append(param);
        String res = DigestUtils.md5Hex(DigestUtils.md5Hex(builder.toString()));


        Header[] headers = new Header[4];
        headers[0] = new BasicHeader("accessKey", accessKey);
        headers[1] = new BasicHeader("reqTime", reqTime);
        headers[2] = new BasicHeader("sign", res);
        headers[3] = new BasicHeader("Content-Type", "application/json");

        //放入头部信息
        httpPost.setHeaders(GetHeaderUtil.getHeader(param.toJSONString()));
        //执行请求
        HttpResponse httpResponse= null;
        try {
            httpResponse = httpClient.execute(httpPost);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //接受entity1
        String entity1= null;
        try {
            entity1 = EntityUtils.toString(httpResponse.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entity1;

    }




}
