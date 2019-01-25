package testApi;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

// HttpClient方式调用接口的实例,这里代码需要导入commons-codec-1.7.jar和commons-logging.jar,不然最后关闭连接时会报错;该方法调用接口更简单,具体看情况使用
// 这里与文件1的区别是1文件传递和获得的数据都是以流的形式处理的,如将参数转为二进制流,和使用postMethod.getResponseBodyAsStream()获得返回的流
public class TestPostHttpClient2 {
    public static void main(String[] args) {
        // 请求接口地址
        String url = "https://api.douban.com/v2/book/user/ahbei/collections";
        // 请求参数
        String status = "read";
        String rating = "4";
        String tag = "小说";

        HttpClient httpclient = null;
        PostMethod post = null;
        try {
            //创建连接
            httpclient = new HttpClient();
            post = new PostMethod(url);
            // 设置编码方式
            post.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
            // 添加参数
            post.addParameter("status", status);
            post.addParameter("rating", rating);
            post.addParameter("tag", tag);
            // 执行请求
            httpclient.executeMethod(post);
            // 接口返回信息

            String info = new String(post.getResponseBody(), "UTF-8");
            System.out.println(info);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                // 关闭连接,释放资源
                post.releaseConnection();
                ((SimpleHttpConnectionManager) httpclient.getHttpConnectionManager()).shutdown();
            }catch (NullPointerException e){
                e.printStackTrace();
            }
        }
    }
}