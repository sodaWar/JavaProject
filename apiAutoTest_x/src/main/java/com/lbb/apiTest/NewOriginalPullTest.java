package com.lbb.apiTest;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lbb.model.TestCaseModel;
import com.lbb.utils.HttpDoRequestUtil;
import com.lbb.utils.MysqlUtil;

import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.List;

public class NewOriginalPullTest {
    MysqlUtil mysqlUtil = new MysqlUtil();
    String url = "http://47.98.155.93:8081/orapi/original/pull";
    private org.slf4j.Logger logger= LoggerFactory.getLogger(this.getClass());

    @Test
    public void newOriginalPullTest(){
    //获取测试数据
    List<TestCaseModel> testCase=mysqlUtil.getSqlSession().selectList("findTestCaseById",1);
    JSONObject object = new JSONObject();


        for (TestCaseModel testCaseModel:testCase){
        object.put(testCaseModel.getKey(), testCaseModel.getValue());
    }
    String entity= HttpDoRequestUtil.doPost(url,object);
    JSONObject jsonObject1= JSON.parseObject(entity);
       logger.info("---------------------------------------"+"\n"+jsonObject1+"\n");

}


}
