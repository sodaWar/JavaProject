package com.lbb.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpDoRequestUtil {
    //这里jsonObject是data参数的实际传递的参数
    public static String doPost(String url, JSONObject jsonObject) throws IOException {

        //创建默认的httpClient实例
        CloseableHttpClient httpClient= HttpClients.createDefault();
        //创建一个HttpPost对象
        HttpPost httpPost=new HttpPost(url);

        //构建消息实体,解决参数中文乱码问题
        StringEntity entity=new StringEntity(jsonObject.toJSONString(),"utf-8");
        //放入参数
        httpPost.setEntity(entity);
        //放入头部信息,构建消息头
        httpPost.setHeaders(GetHeaderUtil.getHeader(jsonObject.toJSONString()));
        //执行请求
        HttpResponse httpResponse= httpClient.execute(httpPost);
        //接受entity1,把EntityUtils.toString()作用是将内容转换成字符串,httpResponse.getEntity()是去获得HttpClient返回的HttpResponse,也就是获得请求的网址的HTML内容
        String entity1=EntityUtils.toString(httpResponse.getEntity());
        return entity1;

    }




}
