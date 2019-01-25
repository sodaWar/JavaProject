package javaExample;
import java.net.*;
import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.text.SimpleDateFormat;


public class JavaNetworkEx {
    public static void main(String[] args) throws Exception{
        /*
        // 使用InetAddress类的InetAddress.getByName()方法来获取指定主机(网址)的IP地址,这里getHostAddress()方法是获取本机ip地址,getHostName()方法是获取主机名
        InetAddress address = null;
        try {
            address = InetAddress.getByName("www.runoob.com");
        }
        catch (UnknownHostException e) {
            System.exit(2);
        }
        System.out.println(address.getHostName() + "=" + address.getHostAddress());
        System.exit(0);

        // 这里使用public Socket(String host,int port)的方法来查看端口是否被占用,该方法是通过一个主机和端口构建一个Socket,构建Socket的时候会连接目标主机,如果连接不到目标主机会抛出IOException或UnknownHostException异常
        Socket Skt;
        String host = "localhost";
        if (args.length > 0) {
            host = args[0];
        }
        for (int i = 890; i < 1024; i++) {
            try {
                System.out.println("查看 "+ i);
                Skt = new Socket(host, i);
                System.out.println("端口 " + i + " 已被使用");
            }
            catch (UnknownHostException e) {
                System.out.println("Exception occured"+ e);
                break;
            }
            catch (IOException e) {
            }
        }

        // 查看主机指定文件的最后修改时间
        URL u = new URL("http://127.0.0.1/test/test.html");
        URLConnection uc = u.openConnection();                                                                          // 得到connection对象
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
        uc.setUseCaches(false);                                                                                         // 请求不能使用缓存
        long timestamp = uc.getLastModified();
        System.out.println("test.html 文件最后修改时间 :" + ft.format(new Date(timestamp)));

        // getInetAddress()方法返回一个InetAddress对象,通过这个对象,可以得到服务器的IP、域名等信息
        try {
            InetAddress addr;
            Socket sock = new Socket("www.runoob.com", 80);
            addr = sock.getInetAddress();
            System.out.println("连接到 " + addr);
            sock.close();
        } catch (java.io.IOException e) {
            System.out.println("无法连接 " + args[0]);
            System.out.println(e);
        }

        // 使用HttpURLConnection的httpCon.getDate()方法来获取URL响应头的日期信息
        URL url = new URL("http://www.runoob.com");
        HttpURLConnection httpCon =
                (HttpURLConnection) url.openConnection();
        long date = httpCon.getDate();
        if (date == 0)
            System.out.println("无法获取信息");
        else
            System.out.println("Date: " + new Date(date));

        // 使用URLConnection的conn.getHeaderFields()方法获得指定URL的响应头信息
        // 使用getProtocol()方法获得协议如http;getFile()获得文件名,这里指/html/html-tutorial.html;getHost()获得主机指www.runoob.com;getPath()获得路径,值跟文件名一样;getPort()获得端口号
        URL url = new URL("http://www.runoob.com/html/html-tutorial.html");
        URLConnection conn = url.openConnection();
        Map headers = conn.getHeaderFields();
        Set<String> keys = headers.keySet();
        for( String key : keys ){
//            String val = conn.getHeaderField(key);                                                                    // 该作用与下面一行代码效果相同,都是获得key对应的value值
            Object val = headers.get(key);                                                                              // 通过Map的get函数获得的value值返回类型是Object类型
            System.out.println(key+"    "+val);
        }
        System.out.println( conn.getLastModified() );                                                                   // 返回头部last-modified字段值
        System.out.println("主机是 " + url.getHost());

*/


    }
}
