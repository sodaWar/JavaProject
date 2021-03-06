package com.lbb.utils;

import com.lbb.model.NameForApi;

import java.util.Locale;
import java.util.ResourceBundle;

public class ReadConfigUtil {
    //读取接口地址文件
    private static ResourceBundle bundle=ResourceBundle.getBundle("apiUrl", Locale.CHINA);
    public static  String getUrl(NameForApi name,String hosts){
        String url=null;
        /**
         * 判断传参为test时，获取测试地址，否则为线上地址
         */
         if(hosts== "test"){
             hosts=bundle.getString("test_hosts_url");
         }else if (hosts=="online"){
             hosts=bundle.getString("online_hosts_url");
         }


        if(name==NameForApi.WRITE_YUQI_URL){
            url=bundle.getString("write_yuqi_url");
        }
        if(name==NameForApi.WRITI_SHEBEI_URL){
            url=bundle.getString("writi_shebei_url");
        }
        if(name==NameForApi.WRITE_BACKLIST_URL){
            url=bundle.getString("write_backList_url");
        }
        if(name==NameForApi.WRITE_ZHIMA_URL){
            url=bundle.getString("write_zhima_url");
        }

        if(name==NameForApi.READ_YUQI_URL){
            url=bundle.getString("read_yuqi_url");
        }
        if(name==NameForApi.READ_SHEBEI_URL){
            url=bundle.getString("read_shebei_url");
        }
        if(name==NameForApi.READ_BACKLIST_URL){
            url=bundle.getString("read_backList_url");
        }
        if(name==NameForApi.READ_ZHIMA_URL){
            url=bundle.getString("read_zhima_url");
        }


        return hosts+url;
    }

}
