package testApi;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class TestGetApi {

    /**
     * Main
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        System.out.println(doGet());
    }

    /**
     * Get Request
     * @return
     * @throws Exception
     */
    public static String doGet() throws Exception {
        URL localURL = new URL("https://www.baidu.com/");
        // 通过统一资源定位器(java.net.URL)获取连接器(java.net.URLConnection)
        URLConnection connection = localURL.openConnection();
        HttpURLConnection httpURLConnection = (HttpURLConnection)connection;
        // 设置请求的参数,并发送请求
        httpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;
        StringBuffer resultBuffer = new StringBuffer();
        String tempLine = null;


        if (httpURLConnection.getResponseCode() >= 300) {
            throw new Exception("HTTP Request is not success, Response code is " + httpURLConnection.getResponseCode());
        }

        try {
            // 以输入流的形式获取返回内容
            inputStream = httpURLConnection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            reader = new BufferedReader(inputStreamReader);

            while ((tempLine = reader.readLine()) != null) {
                resultBuffer.append(tempLine);
            }

        } finally {

            if (reader != null) {
                reader.close();
            }

            if (inputStreamReader != null) {
                inputStreamReader.close();
            }

            if (inputStream != null) {
                inputStream.close();
            }

        }

        return resultBuffer.toString();
    }

}