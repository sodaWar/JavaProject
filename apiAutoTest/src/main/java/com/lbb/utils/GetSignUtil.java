package com.lbb.utils;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Date;

/**
 * sign 生成工具类
 */

public class GetSignUtil {

    private static String accessSecret = "8040c5dbf6978f315e104e5c0bca3e8e2baa4221";

    //获取时间戳
    public static long getReqTime() {
        Date date = new Date();
        long reqTime = date.getTime() / 1000;
        return reqTime;
    }


    //sign加密算法
    public static String getSignForgxpt(String data){
        //创建StringBuilder对象,效果跟StringBuffer类似,可以在字符串修改后不用创建新的对象
        StringBuilder builder = new StringBuilder(accessSecret);
        builder.append(getReqTime());
        builder.append(data);
        //两次加密reqTime+data+accessSecret的值成为sign
        String res = DigestUtils.md5Hex(DigestUtils.md5Hex(builder.toString()));
        return res;
    }

}
