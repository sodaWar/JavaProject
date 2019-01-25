package networkProgram;

import java.net.*;
import java.io.*;

public class SocketClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 1234);   // 通过Socket来建立和服务端的连接
        OutputStream out = socket.getOutputStream();   // 获取输出流（客户端输出流即向服务端输出信息）
        out.write("hello tcp Server".getBytes());  // 输出信息(因为是通过输入输出流来交换数据的,所以需要将数据转换成字节流形式),getBytes方法是得到一个操作系统默认编码格式的字节数组

        InputStream in = socket.getInputStream();   // 接受服务端的消息(意思是获得了服务端返回的数据,但是没有读取和解析它)
        byte b[] = new byte[1024];
        int len = in.read(b);                       // InputStream流有三个方法,read()方法是一次读取一个字节,效率很低,所以最好使用read(byte[] b)的方法,以整数形式返回实际读取的字节数
        System.out.println("接受到服务器消息 ： "+new String(b,0,len));   // 输出,这个String方法中的参数data表示一个字符数组,offset是初始偏移到字符串的值,count是字符串值的长度
        out.write("返回的的数据已经收到 ".getBytes());  // 向服务器返回消息
        socket.close();
    }
}


