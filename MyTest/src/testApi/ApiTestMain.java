package testApi;

import java.util.HashMap;
import java.util.Map;

public class ApiTestMain {

    public static void main(String[] args) throws Exception {

        /* Post Request */
        Map dataMap = new HashMap();
        dataMap.put("status", "read");
        dataMap.put("rating", "4");
        dataMap.put("data", "小说");
        System.out.println(new TestApiEncapsulation().doPost("https://api.douban.com/v2/book/user/ahbei/collections", dataMap));

        /* Get Request */
        System.out.println(new TestApiEncapsulation().doGet("https://www.baidu.com/"));
    }

}