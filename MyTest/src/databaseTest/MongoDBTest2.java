package databaseTest;

import java.util.ArrayList;
import java.util.List;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;


public class MongoDBTest2 {
    public static void main(String[] args){
        try {
            //连接到MongoDB服务 如果是远程连接可以替换“localhost”为服务器所在IP地址
            //ServerAddress()两个参数分别为 服务器地址 和 端口
            ServerAddress serverAddress = new ServerAddress("127.0.0.1",27017);
            List<ServerAddress> addrs = new ArrayList<ServerAddress>();
            addrs.add(serverAddress);

            //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
            MongoCredential credential = MongoCredential.createScramSha1Credential("root", "admin", "123456".toCharArray());
            List<MongoCredential> credentials = new ArrayList<MongoCredential>();
            credentials.add(credential);

            //通过连接认证获取MongoDB连接
            MongoClient mongoClient = new MongoClient(addrs,credentials);

            //连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("mytest");
            System.out.println("Connect to database successfully");
//          创建集合
//            mongoDatabase.createCollection("test_six");
//          获取集合（获取集合不是查询集合的意思！）
            MongoCollection<Document> collection = mongoDatabase.getCollection("test_six");
            System.out.println(collection);
//          插入文档,1.创建文档 org.bson.Document 参数为key-value的格式 2.创建文档集合List<Document> 3.将文档集合插入数据库集合中
//            Document document = new Document("title", "MongoDB").
//                    append("description", "database").
//                    append("likes", 100).
//                    append("by", "Fly");
//            List<Document> documents = new ArrayList<Document>();
//            documents.add(document);
//            collection.insertMany(documents);
//            System.out.println("文档插入成功");

//          更新文档
            collection.updateMany(Filters.eq("likes", 100), new Document("$set",new Document("likes",200)));
//          删除符合条件的第一个文档
            collection.deleteOne(Filters.eq("likes", 200));
//          删除所有符合条件的文档
            collection.deleteMany (Filters.eq("likes", 200));


//          检索所有文档,find()是查询所有文档信息,返回FindIterable<Document>类型
            FindIterable<Document> findIterable = collection.find();                                                    // 获取迭代器FindIterable<Document>
            FindIterable<Document> findIterable2 = collection.find(new Document("likes",new Document("$gt",99)));       // 查询出likes字段值大于99的所有文档信息
            FindIterable<Document> findIterable3 = collection.find(Filters.gt("likes",99));             // 效果与上面相同,只是通过过滤器Filters来实现,Filters提供了一系列查询条件的静态方法
            MongoCursor<Document> mongoCursor = findIterable.iterator();                                                // 获取游标MongoCursor<Document>
            while(mongoCursor.hasNext()){                                                                               // 通过游标遍历检索出的文档集合
                System.out.println(mongoCursor.next());
            }


        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.err.println( "this is test24 branch" );
        }
    }
}