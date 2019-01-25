package databaseTest;

import redis.clients.jedis.Jedis;
import java.util.Set;
import java.util.Iterator;
import java.util.List;

public class RedisTest {
    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("127.0.0.1");
        System.out.println("连接成功");
//        //查看服务是否运行
//        System.out.println("服务正在运行: "+jedis.ping());

////      设置redis字符串数据
//        jedis.set("javaTestRedis","www.baidu.com");
////      获取存储的数据并输出
//        System.out.println("redis中存储的字符串："+jedis.get("javaTestRedis"));
//
////      存储数据到列表中
//        jedis.lpush("site-list","java");                                                                              // 将一个或多个值插入到列表头部
//        jedis.lpush("site-list","python");
//        jedis.lpush("site-list","c++");
////      获取存储的数据并输出
//        List<String> list = jedis.lrange("site-list",0,2);                                                            // 获取列表指定范围内的元素
//        for (String mykey:list) {
//            System.out.println("列表项的值是："+mykey);
//        }

////      获取redis中的key数据并输出
//        Set<String> keys = jedis.keys("*");
//        Iterator<String> it = keys.iterator();
//        while (it.hasNext()){
//            String key = it.next();
//            System.out.println(key);
//        }

//      存储数据到set集合中
//        jedis.sadd("myset","java");
//        jedis.sadd("myset","python");
//        jedis.sadd("myset","c++");
//        System.out.println("redis中存储的set集合值："+jedis.smembers("myset"));

//      存储数据到zset集合中
        jedis.zadd("myzset",1,"java");
        jedis.zadd("myzset",0,"python");
        jedis.zadd("myzset",2,"c++");
        System.out.println("redis中存储的zset集合值："+jedis.zrangeByScore("myzset",0,10));
    }
}