package com.lbb.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

//发送http请求类
public class HttpDoRequestUtil {

    //post请求
    public static String doPost(String url, JSONObject jsonObject)  {

        CloseableHttpClient httpClient= HttpClients.createDefault();
        HttpPost httpPost=new HttpPost(url);

        //把参数转换成entity
        StringEntity entity=new StringEntity(jsonObject.toJSONString(),"utf-8");
        //放入参数
        httpPost.setEntity(entity);
        //放入头部信息
        httpPost.setHeaders(GetHeaderUtil.getHeader(jsonObject.toJSONString()));
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
