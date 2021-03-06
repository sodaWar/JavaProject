package com.lbb.utils;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import static com.lbb.utils.GetSignUtil.getReqTime;

/**
 * 头部信息工具类
 */
public class GetHeaderUtil {
    public static Header[] getHeader(String data){
        //这里的Header类的作用是组装请求头,将头部的相关信息组装到一个Header数组中
        Header[]headers=new Header[4];
        headers[0]=new BasicHeader("accessKey","7ef9a26e5a32ca9699b930541875dbfb");
        headers[1]=new BasicHeader("reqTime",String.valueOf(getReqTime()));
        headers[2]=new BasicHeader("sign",GetSignUtil.getSignForgxpt(data));
        headers[3]=new BasicHeader("Content-Type","application/json");
        return headers;

    }
}
