package databaseTest;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDBTest{
    public static void main( String args[] ){
        try{
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient( "127.0.0.1" , 27017 );

            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("admin");
            System.out.println("Connect to database successfully");
//          创建集合
            mongoDatabase.createCollection("test_three");
//          获取集合
            MongoCollection<Document> collection = mongoDatabase.getCollection("test_two");
            System.out.print(collection);
        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.err.println( "this is test22 branch" );
        }
    }
}


