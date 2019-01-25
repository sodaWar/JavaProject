package testApi;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class TestPostApi {

    /**
     * Main
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        System.out.println(doPost());
    }

    /**
     * Post Request
     * @return
     * @throws Exception
     */
    public static String doPost() throws Exception {
        String parameterData = "status=read&rating=4&tag=小说";
        URL localURL = new URL("https://api.douban.com/v2/book/user/ahbei/collections");
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
        StringBuffer resultBuffer = new StringBuffer();
        String tempLine = null;

        try {
            // getOutputStream()返回URL的输出流,用于写入资源
            outputStream = httpURLConnection.getOutputStream();
            /* 构造一个默认编码集的OutputStreamWriter类,这里outputStream是上面返回的URL输出流,只有获得URL的输出流后,才能对URL进行写入资源操作.
            如果该方法的参数out对象是通过InputStream out = System.out;获得,那么最后就会写入字符串然后打印到控制台上 */
            outputStreamWriter = new OutputStreamWriter(outputStream);
            // 将字符串写入(该方法有int off和int len参数,可将字符串部分写入),toString()是转换为字符串,这里是发送请求参数的作用
            outputStreamWriter.write(parameterData.toString());
            /* java在使用流时,都会有一个缓冲区,按一种它认为比较高效的方法来发数据:把要发的数据先放到缓冲区,缓冲区放满以后再一次性发过去,而不是分开一次一次地发.flush()表示强制将缓冲区中的数据发送出去,不必等到缓冲区满
            所以如果在用流的时候,没有用flush()这个方法,很多情况下会出现流的另一边读不到数据的问题,特别是在数据特别小的情况下
            */
            outputStreamWriter.flush();

            if (httpURLConnection.getResponseCode() >= 300) {
                throw new Exception("HTTP Request is not success, Response code is " + httpURLConnection.getResponseCode());
            }
            // 读取URL的资源内容,如InputStream in = new FileInputStream("D:\\demo.txt")就是读取文件的数据
            inputStream = httpURLConnection.getInputStream();
            // 将字节流向字符流转换
            inputStreamReader = new InputStreamReader(inputStream);
            // 使用缓冲区
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

        return resultBuffer.toString();
    }



}