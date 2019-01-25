package com.lbb.apiTest;

import com.alibaba.fastjson.JSONObject;
import com.lbb.model.NameForApi;
import com.lbb.utils.HttpDoRequestUtil;
import com.lbb.utils.MongoDbJDBCUtil;
import com.lbb.utils.ReadConfigUtil;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


import static com.mongodb.client.model.Filters.regex;


public class AddBackListTest {
    private String name="郝熙运3";

    @Test
    public void addBackList() throws IOException {
       String url= ReadConfigUtil.getUrl(NameForApi.WRITE_YUQI_URL,"test");
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("orgId", "即呗网络");
        jsonObject.put("uid", "360926197302164710");
        jsonObject.put("mobile", "13854212365");
        jsonObject.put("name", name);
        jsonObject.put("data", "{\"orderId\": \"51闪电购\",\"timeOutDay\": \"5\",\"isSelf\": \"1\",\"status\": \"8\"}");

        String entity  =  HttpDoRequestUtil.doPost(url,jsonObject);
        System.out.print(entity);

        //获取需要查询的集合（表名）,并根据条件执行查询
        FindIterable<Document> findIterable
                =MongoDbJDBCUtil.getMongoCollection("dx_original_all").find(regex("name",name));
        MongoCursor<Document> cursor=findIterable.iterator();

        Document cursors=null;
        //遍历
        while (cursor.hasNext()){
            cursors=cursor.next();
        }

        //断言数据库的获取到的name和name比较
        Assert.assertEquals(cursors.get("name"),name);

        System.out.println("添加的数据是-----------"+"\n"+cursors+"\r");
    }

    //删除添加的数据
    @Test(dependsOnMethods = {"addBackList"})
    public void remove(){

        BasicDBObject queryObject = new BasicDBObject("name",name);

        MongoDbJDBCUtil.getMongoCollection("dx_original_all").deleteMany(queryObject);

    }

}
