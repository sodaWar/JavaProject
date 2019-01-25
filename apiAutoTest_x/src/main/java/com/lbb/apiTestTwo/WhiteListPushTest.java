package com.lbb.apiTestTwo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lbb.model.*;
import com.lbb.utils.HttpDoRequestUtil;
import com.lbb.utils.MysqlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

//爱信钱包白名单
public class WhiteListPushTest {
    //    MysqlUtil mysqlUtil=new MysqlUtil();
    private String hosts = "http://47.98.155.93:8081";

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //写入白名单
    @Test
    public void whiteListPush() {


        String path = "/owapi/aiXinQianBaoWhiteList/push";
        String url = hosts + path;

        JSONObject json = new JSONObject();
        json.put("userName", "测试");
        json.put("mobile", "18688888888");
        json.put("timeoutDay", "30");
        json.put("userLabel", "10");
        json.put("zhimaScore", "650");

        String entity = HttpDoRequestUtil.doPost(url, json);

        JSONObject jsonObject = JSON.parseObject(entity);

        if (jsonObject.getString("code").equals("1000000")) {
            logger.info("接口请求成功----------" + jsonObject);
            TAixinqianbaoWhiteList ta = MysqlUtil.getSqlSession().selectOne("findWhiteByMobile", "18688888888");
            String mobile = ta.getMobile();
            //判断查询到的数据和插入的数据进行对比
            Assert.assertEquals(mobile, "18688888888");
        } else {
            logger.error("接口请求出错了，请检查");
        }

    }


    //爱信钱包一直被拒
    @Test
    public void tAllRejectedTest() {
        String path = "/owapi/allRejected/push";
        String url = hosts + path;
        JSONObject json = new JSONObject();
        json.put("userName", "测试");
        json.put("mobile", "18688888888");
        json.put("idcard", "305252512221122");
        json.put("rejectN", "10");

        String entity = HttpDoRequestUtil.doPost(url, json);

        JSONObject jsonObject = JSON.parseObject(entity);

        if (jsonObject.getString("code").equals("1000000")) {

            logger.info("接口请求成功----------" + jsonObject);
            TAllRejectedModel ta = MysqlUtil.getSqlSession().selectOne("findTAllRejectedBymobile", "18688888888");
            String mobile = ta.getMobile();
            //判断查询到的数据和插入的数据进行对比
            Assert.assertEquals(mobile, "18688888888");
        } else {

            logger.error("接口请求出错了，请检查");
        }


    }

    //设备id黑名单列表
    @Test
    public void tDeviceIdBlackList() {
        String path = "/owapi/deviceIdBlackList/push";
        String url = hosts + path;
        JSONObject json = new JSONObject();
        json.put("deviceid", "18688888888");
        json.put("cntN", "");
        json.put("label", "10");

        String entity = HttpDoRequestUtil.doPost(url, json);

        JSONObject jsonObject = JSON.parseObject(entity);

        if (jsonObject.getString("code").equals("1000000")) {

            logger.info("接口请求成功----------" + jsonObject);
            TDeviceidblackListModel ta = MysqlUtil.getSqlSession().selectOne("findtDeviceIdBlackListBydeviceID", "18688888888");
            String deviceid = ta.getDeviceID();
            //判断查询到的数据和插入的数据进行对比
            Assert.assertEquals(deviceid, "18688888888");
        } else {

            logger.error("接口请求出错了，请检查");
        }


    }

    //IP黑名单列表，请求URL：
    @Test
    public void ipBlackList() {
        String path = "/owapi/ipBlackList/push";
        String url = hosts + path;
        JSONObject json = new JSONObject();
        json.put("ip", "18688888888");

        String entity = HttpDoRequestUtil.doPost(url, json);

        JSONObject jsonObject = JSON.parseObject(entity);

        if (jsonObject.getString("code").equals("1000000")) {
            logger.info("接口请求成功----------" + jsonObject);
            TIpblackListModel ta = MysqlUtil.getSqlSession().selectOne("findTIpblackListByIp", "18688888888");
            String deviceid = ta.getIP();
            //判断查询到的数据和插入的数据进行对比
            Assert.assertEquals(deviceid, "18688888888");
        } else {

            logger.error("接口请求出错了，请检查");
        }


    }

    //是否黑名单列表
    @Test
    public void tIsBlackList() {
        String path = "/owapi/isBlackList/push";
        String url = hosts + path;
        JSONObject json = new JSONObject();
        json.put("phone", "18688888888");
        json.put("idNumber", "18688888888");
        json.put("name", "18688888888");
        json.put("moneyAmount", "18688888888");
        json.put("loanTerm", "18688888888");
        json.put("orderTime", "2018-05-24 15:05:33");
        json.put("isBlack", "");

        String entity = HttpDoRequestUtil.doPost(url, json);

        JSONObject jsonObject = JSON.parseObject(entity);

        if (jsonObject.getString("code").equals("1000000")) {

            logger.info("接口请求成功----------" + jsonObject);
            TIsblackListModel ta = MysqlUtil.getSqlSession().selectOne("findTIsBlackListByPhone", "18688888888");
            String deviceid = ta.getPhone();
            //判断查询到的数据和插入的数据进行对比
            Assert.assertEquals(deviceid, "18688888888");
        } else {

            logger.error("接口请求出错了，请检查");
        }


    }

    //已贷款信息列表
    @Test
    public void LoanAlreadyList() {
        String path = "/owapi/loanAlreadyList/push";
        String url = hosts + path;
        JSONObject json = new JSONObject();
        json.put("phone", "18688888888");
        json.put("idNumber", "18688888888");
        json.put("name", "18688888888");
        json.put("moneyAmount", "18688888888");
        json.put("loanTerm", "18688888888");
        json.put("orderTime", "2018-05-24 15:05:33");
        json.put("isBlack", "");

        String entity = HttpDoRequestUtil.doPost(url, json);

        JSONObject jsonObject = JSON.parseObject(entity);

        if (jsonObject.getString("code").equals("1000000")) {

            logger.info("接口请求成功----------" + jsonObject);
            TLoanAlreadyListModel ta = MysqlUtil.getSqlSession().selectOne("findTLoanAlreadyListByPhone", "18688888888");
            String deviceid = ta.getPhone();
            //判断查询到的数据和插入的数据进行对比
            Assert.assertEquals(deviceid, "18688888888");
        } else {

            logger.error("接口请求出错了，请检查");
        }


    }


}
