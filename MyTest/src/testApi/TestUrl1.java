package testApi;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class TestUrl1 {
    public static void main(String[] args) throws IOException {
        test4();
        test3();
        test2();
        test();
    }

    /**
     * 获取URL指定的资源。
     *
     * @throws IOException
     */
    public static void test4() throws IOException {
        URL url = new URL("http://lavasoft.blog.51cto.com/attachment/200811/200811271227767778082.jpg");
        //获得此URL的内容
        Object obj = url.getContent();
        System.out.println(obj.getClass().getName());
    }

    /**
     * 获取URL指定的资源
     *
     * @throws IOException
     */
    public static void test3() throws IOException {
        URL url = new URL("https://www.baidu.com/");
        // 返回一个 URLConnection 对象,它表示到 URL 所引用的远程对象的连接。
        URLConnection uc = url.openConnection();
        // 打开的连接读取的输入流。
        InputStream in = uc.getInputStream();
        int c;
        while ((c = in.read()) != -1)
            System.out.print(c);
        in.close();
    }

    /**
     * 读取URL指定的网页内容
     *
     * @throws IOException
     */
    public static void test2() throws IOException {
        URL url = new URL("https://www.baidu.com/");
        // 打开到此URL的连接并返回一个用于从该连接读入的InputStream
        Reader reader = new InputStreamReader(new BufferedInputStream(url.openStream()));
        int c;
        while ((c = reader.read()) != -1) {
            System.out.print((char) c);
        }
        reader.close();
    }

    /**
     * 获取URL的输入流，并输出
     *
     * @throws IOException
     */
    public static void test() throws IOException {
        URL url = new URL("https://www.baidu.com/");
        // 打开到此URL的连接并返回一个用于从该连接读入的InputStream
        InputStream in = url.openStream();
        int c;
        while ((c = in.read()) != -1)
            System.out.print(c);
        in.close();
    }
}
