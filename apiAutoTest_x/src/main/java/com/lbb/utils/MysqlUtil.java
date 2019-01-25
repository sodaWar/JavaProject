package com.lbb.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;


public class MysqlUtil {

    private static SqlSession instance;

    public MysqlUtil(){
//        System.out.println("Singleton has loaded");
    }

    public static SqlSession getSqlSession()  {
        //获取配置的资源文件
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("databaseConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //得到SqlSessionFactory，使用类加载器加载xml文件
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
        //得到sqlsession对象，这个对象就能执行配置文件中的sql语句啦
        if (instance == null){
            instance = factory.openSession();
        }
        return instance;
    }
}
