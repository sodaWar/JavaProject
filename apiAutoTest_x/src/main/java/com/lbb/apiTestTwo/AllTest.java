package com.lbb.apiTestTwo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lbb.utils.HttpDoRequestUtil;
import com.lbb.utils.MysqlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class AllTest {
    private String hosts="http://47.98.155.93:8081";
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //读取白名单
    @Test
    public void whiteListPush(){

        String path="/orapi/aiXinQianBaoWhiteList/pull";
        String  url=hosts+path;

        JSONObject json =new JSONObject();
        json.put("mobile","18688888888");

        String entity= HttpDoRequestUtil.doPost(url,json);
        JSONObject jsonObject = JSON.parseObject(entity);

        if (jsonObject.getString("code").equals("1000000")){
            logger.info("接口请求成功----------"+jsonObject);

            Assert.assertEquals(jsonObject.getJSONObject("data").getString("mobile"),"18688888888");

        }else {
            logger.error("接口请求出错了，请检查");
            throw new RuntimeException();
        }

    }


    // 读取爱信钱包一直被拒
    @Test
    public void readallRejected(){

        String path="/orapi/allRejected/pull";
        String  url=hosts+path;

        JSONObject json =new JSONObject();
        json.put("mobile","18688888888");

        String entity= HttpDoRequestUtil.doPost(url,json);
        JSONObject jsonObject = JSON.parseObject(entity);

        if (jsonObject.getString("code").equals("1000000")){
            logger.info("接口请求成功----------"+jsonObject);

            Assert.assertEquals(jsonObject.getJSONObject("data").getString("mobile"),"18688888888");

        }else {
            logger.error("接口请求出错了，请检查");
        }

    }

    //设备id黑名单列表
    @Test
    public void readdeviceIdBlackList(){

        String path="/orapi/deviceIdBlackList/pull";
        String  url=hosts+path;

        JSONObject json =new JSONObject();
        json.put("deviceid","18688888888");

        String entity= HttpDoRequestUtil.doPost(url,json);
        JSONObject jsonObject = JSON.parseObject(entity);

        if (jsonObject.getString("code").equals("1000000")){
            logger.info("接口请求成功----------"+jsonObject);

            Assert.assertEquals(jsonObject.getJSONObject("data").getString("deviceid"),"18688888888");

        }else {
            logger.error("接口请求出错了，请检查");
        }

    }
    // IP黑名单列表
    @Test
    public void readipBlackList(){

        String path="/orapi/ipBlackList/pull";
        String  url=hosts+path;

        JSONObject json =new JSONObject();
        json.put("ip","18688888888");

        String entity= HttpDoRequestUtil.doPost(url,json);
        JSONObject jsonObject = JSON.parseObject(entity);

        if (jsonObject.getString("code").equals("1000000")){
            logger.info("接口请求成功----------"+jsonObject);

            Assert.assertEquals(jsonObject.getJSONObject("data").getString("ip"),"18688888888");

        }else {
            logger.error("接口请求出错了，请检查");
        }

    }

    //是否黑名单列表
    @Test
    public void readisBlackList(){

        String path="/orapi/isBlackList/pull";
        String  url=hosts+path;

        JSONObject json =new JSONObject();
        json.put("phone","18688888888");

        String entity= HttpDoRequestUtil.doPost(url,json);
        JSONObject jsonObject = JSON.parseObject(entity);

        if (jsonObject.getString("code").equals("1000000")){
            logger.info("接口请求成功----------"+jsonObject);

            Assert.assertEquals(jsonObject.getJSONObject("data").getString("phone"),"18688888888");

        }else {
            logger.error("接口请求出错了，请检查");
        }

    }

    // 已贷款信息列表
    @Test
    public void readloanAlreadyList(){

        String path="/orapi/loanAlreadyList/pull";
        String  url=hosts+path;

        JSONObject json =new JSONObject();
        json.put("phone","18688888888");

        String entity= HttpDoRequestUtil.doPost(url,json);
        JSONObject jsonObject = JSON.parseObject(entity);

        if (jsonObject.getString("code").equals("1000000")){
            logger.info("接口请求成功----------"+jsonObject);

            Assert.assertEquals(jsonObject.getJSONObject("data").getString("phone"),"18688888888");

        }else {
            logger.error("接口请求出错了，请检查");
        }

    }
   @AfterTest
    public void dele(){
        String st="18688888888";
       MysqlUtil.getSqlSession().delete("deleteWhite",st);
       MysqlUtil.getSqlSession().delete("deleteTAllRejected",st);
       MysqlUtil.getSqlSession().delete("deleteDevice",st);
       MysqlUtil.getSqlSession().delete("deleteTIpblackList",st);
       MysqlUtil.getSqlSession().delete("deleteTIsBlackList",st);
       MysqlUtil.getSqlSession().delete("deleteTLoanAlreadyList",st);
       MysqlUtil.getSqlSession().commit();
       MysqlUtil.getSqlSession().close();


    }

}
