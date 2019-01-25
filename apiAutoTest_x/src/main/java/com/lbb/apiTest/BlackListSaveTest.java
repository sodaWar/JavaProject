package com.lbb.apiTest;

import com.alibaba.fastjson.JSONObject;
import com.lbb.model.NameForApi;
import com.lbb.model.TBlacklistModel;
import com.lbb.model.TGreyListModel;
import com.lbb.model.TWhiteListModel;
import com.lbb.utils.HttpDoRequestUtil;
import com.lbb.utils.MysqlUtil;
import com.lbb.utils.ReadConfigUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


public class BlackListSaveTest {

    private static String mobile = "13854212365";
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public Map addMap() {
        Map<String, String> map = new HashMap();
        map.put("orgId", "1");
        map.put("orgName", "51闪电购");
        map.put("mobile", mobile);
        return map;

    }

    @Test(groups = "91")
    public Map addMapTwo() {
        Map<String, String> map = new HashMap();
        map.put("orgId", "2");
        map.put("orgName", "91极速购");
        map.put("mobile", mobile);
        return map;

    }


    @Test( description = "添加灰名单")
    public void addGreyByParam() {


        MysqlUtil.getSqlSession().insert("addGreyByParam", addMap());
        MysqlUtil.getSqlSession().commit();

        //判断是否添加成功
        TGreyListModel tGreyListModel=MysqlUtil.getSqlSession().selectOne("findGreyByParam", addMap());
        logger.info("灰名单单添加信息-----------------"+tGreyListModel);
        Assert.assertEquals(tGreyListModel.getOrgName(),"51闪电购");


    }

    @Test(description = "添加白名单")
    public void addWhiteByParam() {
        MysqlUtil.getSqlSession().insert("addWhiteByParam", addMap());
        MysqlUtil.getSqlSession().commit();

        //判断是否添加成功
        TWhiteListModel tWhiteListModels=MysqlUtil.getSqlSession().selectOne("findWhiteByParam", addMap());
        logger.info("白名单添加信息-----------------"+tWhiteListModels);
        Assert.assertEquals(tWhiteListModels.getOrgName(),"51闪电购");


    }



    @Test(groups = "91", description = "91添加灰名单")
    public void addGreyByParamTwo() {
        MysqlUtil.getSqlSession().insert("addGreyByParam", addMapTwo());
        MysqlUtil.getSqlSession().commit();


    }

    @Test(groups = "91", description = "91添加白名单")
    public void addWhiteByParamTwo() throws SQLException {
        MysqlUtil.getSqlSession().insert("addWhiteByParam", addMapTwo());
        MysqlUtil.getSqlSession().commit();

    }

    //添加黑名单的同时，清洗白名单和灰名单数据
    @Test(dependsOnMethods = {"addGreyByParam","addWhiteByParam","addGreyByParamTwo","addWhiteByParamTwo"},description = "黑名单数据上行接口调用")
    public void blackListSaveTest() {
        String url = ReadConfigUtil.getUrl(NameForApi.NEW_WRITE_BACKLIST, "test");


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("category", "1");
        jsonObject.put("label", "");
        jsonObject.put("mobile", mobile);
        jsonObject.put("timeoutDay", "5");
        jsonObject.put("userName", "测试");
        jsonObject.put("state", "1");

        //执行接口请求
        String entity = HttpDoRequestUtil.doPost(url, jsonObject);
        logger.info("-----接口blackListSaveTest-----entity-----------------"+entity);

        //查询数据库黑名单表
        TBlacklistModel tblacklistModel = MysqlUtil.getSqlSession().selectOne("findBckByParam", addMap());
            //获取黑名单mobile
        String moblie1 = tblacklistModel.getMobile();

        //判断是否添加成功
        Assert.assertEquals(moblie1, mobile);

    }



    @Test(dependsOnMethods = "blackListSaveTest",description = "判断黑名单添加后，是否删除了白名单数据")
    public void findWhiteByParam() {

        TWhiteListModel tWhiteListModel = MysqlUtil.getSqlSession().selectOne("findWhiteByParam", addMap());

        Assert.assertEquals(tWhiteListModel, null);

    }

    @Test(dependsOnMethods = "blackListSaveTest",description = "判断黑名单添加后，是否删除了灰名单数据")
    public void findGreyByParam() {

        TGreyListModel tGreyListModel = MysqlUtil.getSqlSession().selectOne("findGreyByParam", addMap());
        logger.info("------------------"+String.valueOf(tGreyListModel));
        Assert.assertEquals(tGreyListModel, null);

    }


    @Test( dependsOnMethods = "blackListSaveTest",groups = "91", description = "判断黑名单添加后，是否删除了91白名单数据")
    public void findWhiteByParamTwo() {

        TWhiteListModel tWhiteListModels = MysqlUtil.getSqlSession().selectOne("findWhiteByParam", addMapTwo());
        //预期没有删除91数据
        Assert.assertEquals(tWhiteListModels.getOrgName(), "91极速购");
        Assert.assertEquals(tWhiteListModels.getOrgId(), "2");

    }

    @Test(dependsOnMethods = "blackListSaveTest",groups = "91", description = "判断黑名单添加后，是否删除了91灰名单数据")
    public void findGreyByParamTwo() {

        TGreyListModel tGreyListModeld = MysqlUtil.getSqlSession().selectOne("findGreyByParam", addMapTwo());
        //预期没有删除91数据
        Assert.assertEquals(tGreyListModeld.getOrgName(), "91极速购");
        Assert.assertEquals(tGreyListModeld.getOrgId(), "2");

    }

    @AfterClass(description = "数据还原")
    public void stop() {
        MysqlUtil.getSqlSession().delete("deleteBackByParam",mobile);
        MysqlUtil.getSqlSession().delete("deleGreyByParam",mobile);
        MysqlUtil.getSqlSession().delete("deleWhiteByParam",mobile);
        MysqlUtil.getSqlSession().commit();

        MysqlUtil.getSqlSession().close();
    }


}
