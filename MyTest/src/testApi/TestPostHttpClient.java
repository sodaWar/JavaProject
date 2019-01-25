package testApi;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;

//
//public class TestPostHttpClient {
//
//    /**
//     * 发送post请求
//     *
//     * @author Michael -----CSDN: http://blog.csdn.net/capmiachael
//     * @param params
//     *            参数
//     * @param requestUrl
//     *            请求地址
//     * @param
//     *
//     * @return 返回结果
//     * @throws IOException
//     */
//    public static String sendPost(String params, String requestUrl
//                                  ) throws IOException {
//
//        byte[] requestBytes = params.getBytes("utf-8"); // 将参数转为二进制流
//        HttpClient httpClient = new HttpClient();                                                    // 创建httpClient对象
//        PostMethod postMethod = new PostMethod(requestUrl);                                         // 使用httpclient的postMethod方法发送请求,这里是创建post方法的实例
//        // 设置请求头Authorization
////        postMethod.setRequestHeader("Authorization", "Basic " + authorization);
//        // 设置请求头Content-Type
//        postMethod.setRequestHeader("Content-Type", "application/json");
//        InputStream inputStream = new ByteArrayInputStream(requestBytes, 0,
//                requestBytes.length);
//        // 使用RequestEntity接口传递数据,这里是传递一个字节数组类型的参数,设置post请求的参数
//        RequestEntity requestEntity = new InputStreamRequestEntity(inputStream,
//                requestBytes.length, "application/json; charset=utf-8"); // 请求体
//        postMethod.setRequestEntity(requestEntity);
//
//        httpClient.executeMethod(postMethod);// 执行post请求
//        InputStream soapResponseStream = postMethod.getResponseBodyAsStream();// 获取返回的流
//        byte[] datas = null;
//        try {
//            datas = readInputStream(soapResponseStream);// 从输入流中读取数据
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        String result = new String(datas, "UTF-8");// 将二进制流转为String
//        // 打印返回结果
//        System.out.println(result);
//
//        return result;
//
//    }
//
//    /**
//     * 从输入流中读取数据
//     *
//     * @param inStream
//     * @return
//     * @throws Exception
//     */
//    public static byte[] readInputStream(InputStream inStream) throws Exception {
//        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
//        byte[] buffer = new byte[1024];
//        int len = 0;
//        while ((len = inStream.read(buffer)) != -1) {
//            outStream.write(buffer, 0, len);
//        }
//        byte[] data = outStream.toByteArray();
//        outStream.close();
//        inStream.close();
//        return data;
//    }
//}

public class TestPostHttpClient {
    public static void sendPost(Map<String,String> parameterMap, String requestUrl) throws Exception {
        StringBuilder parameterData = new StringBuilder();
        if (parameterMap != null) {
            // keySet()方法获取所有的Map对象的key值,迭代器是一个对象,它可以遍历并选择序列中的对象,使用方法iterator()要求容器返回一个Iterator,返回一个序列值,该序列包含所有的key值
            Iterator iterator = parameterMap.keySet().iterator();
            String key = null;
            String value = null;
            // hasNext()检查序列中是否还有元素,next()获得序列中的下一个元素
            while (iterator.hasNext()) {
                key = (String)iterator.next();
                if (parameterMap.get(key) != null) {
                    value = (String)parameterMap.get(key);
                } else {
                    value = "";
                }
                // 将map对象的key和value值添加到一个parameterBuffer对象中,目的是将map数据转换为string类型的数据
                parameterData.append(key).append("=").append(value);
                if (iterator.hasNext()) {
                    parameterData.append("&");
                }
            }
        }
        // 这里parameterBuffer是post接口请求的参数
        System.out.println("POST parameter : " + parameterData.toString());

        URL localURL = new URL(requestUrl);
        URLConnection connection = localURL.openConnection();
        HttpURLConnection httpURLConnection = (HttpURLConnection)connection;
        // setDoOutput()作用是URL 连接可用于输入和或输出,如果打算使用URL连接进行输出,则将DoOutput标志设置为true
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        // String.valueOf()是删除头尾空白符的字符串
        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(parameterData.length()));
        // InputStreamReader 和 OutputStreamWriter为各种输入输出字符流的基类,作用是将输入字节流转换成字符流,便于读写操作
        OutputStream outputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;
        StringBuilder resultBuffer = new StringBuilder();
        String tempLine = null;

        try {
            outputStream = httpURLConnection.getOutputStream();
            outputStreamWriter = new OutputStreamWriter(outputStream);
            outputStreamWriter.write(parameterData.toString());
            outputStreamWriter.flush();

            if (httpURLConnection.getResponseCode() >= 300) {
                throw new Exception("HTTP Request is not success, Response code is " + httpURLConnection.getResponseCode());
            }
            inputStream = httpURLConnection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            reader = new BufferedReader(inputStreamReader);

            while ((tempLine = reader.readLine()) != null) {
                resultBuffer.append(tempLine);
            }

        } finally {

            if (outputStreamWriter != null) {
                outputStreamWriter.close();
            }

            if (outputStream != null) {
                outputStream.close();
            }

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
        System.out.println( resultBuffer.toString());
    }
}


