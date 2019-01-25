package testApi;
import java.net.*;
import java.io.*;

public class TestUrl2
{
    public static void main(String [] args)
    {
        try
        {
            // openConnection()返回一个 java.net.URLConnection,如果你连接HTTP协议的URL,openConnection()方法返回HttpURLConnection对象,如果你连接的URL为一个JAR文件,返回JarURLConnection对象
            URL url = new URL("http://www.runoob.com");
            URLConnection urlConnection = url.openConnection();
            HttpURLConnection connection = null;
            if(urlConnection instanceof HttpURLConnection)
            {
                connection = (HttpURLConnection) urlConnection;
            }
            else
            {
                System.out.println("请输入 URL 地址");
                return;
            }
            /* java中有三个类用来处理数据流,InputStream是所有字节输入流的超类,一般使用它的子类：FileInputStream等,它能输出字节流
               InputStreamReader是字节流与字符流之间的桥梁,能将字节流转化为字符流,并且能为字节流指定字符集,可输出一个个的字符;
               BufferedReader提供通用的缓冲方式文本读取,readLine读取一个文本行,从字符输入流中读取文本,缓冲各个字符,从而提供字符、数组和行的高效读取,作用是将字符流以缓存的形式一行一行输出
               url类中的方法openConnection()返回一个java.net.URLConnection,而getInputStream()是URLConnection类的方法,返回URL的输入流,用于读取资源
               InputStreamReader以字符流输出比InputStream以字节流输出速度要快,而BufferedReader是获取字符流后,可直接缓存,然后从缓存区取出,这种方式的输出速度比InputStreamReader又快很多
               所以,在读取网络数据流的时候,可以通过先用InputStream获取字节流、InputStreamReader将字节流转化成字符流、BufferedReader将字符流以缓存形式输出的方式来快速获取网络数据流
            */
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String urlString = "";
            String current;
            while((current = in.readLine()) != null)
            {
                urlString += current;
            }
            System.out.println(urlString);
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}