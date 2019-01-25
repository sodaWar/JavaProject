package testApi;
import java.util.HashMap;
import java.util.Map;

public class ApiTestMain2 {
    public static void main(String[] args){
        String requestUrl = "https://api.douban.com/v2/book/user/ahbei/collections";
        Map parameterMap = new HashMap();
        parameterMap.put("status", "read");
        parameterMap.put("rating", "4");
        parameterMap.put("data", "小说");
        TestPostHttpClient hClient = new TestPostHttpClient();
        try {
            hClient.sendPost(parameterMap,requestUrl);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
