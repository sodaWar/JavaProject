package com.lbb.utils;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
//mongodb连接类
public class MongoDbJDBCUtil {

    private static String host="47.98.116.205";
    private static int port=27017;
    private static String userName="shareuser";
    private static String pwdWord="vSWQugj2Gz8HbGn6";
    private static String databaseName="datashare";

    /**
     *
     * @param name 查询mongo的哪个表
     * @return
     */
    public static MongoCollection getMongoCollection(String name){
        try {
            //连接到MongoDB服务 如果是远程连接可以替换“localhost”为服务器所在IP地址
            //ServerAddress()两个参数分别为 服务器地址 和 端口
            ServerAddress serverAddress = new ServerAddress(host,port);
            List<ServerAddress> addrs = new ArrayList<ServerAddress>();
            addrs.add(serverAddress);

            //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
            MongoCredential credential = MongoCredential.createScramSha1Credential(userName, databaseName,pwdWord.toCharArray());
            List<MongoCredential> credentials = new ArrayList<MongoCredential>();
            credentials.add(credential);

            //通过连接认证获取MongoDB连接
            MongoClient mongoClient = new MongoClient(addrs,credentials);

            //连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase(databaseName);

            //获取需要查询的集合（表名）
            MongoCollection<Document> collection=mongoDatabase.getCollection(name);

            return collection;

        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        return null;
    }
}
