package networkProgram;

import java.net.*;
import java.io.*;

//public class SocketServer {
//    public static void main(String[] args) throws IOException {
//        ServerSocket serverSocket = new ServerSocket(8886);  // 建立服务端，ip为本机ip,端口为8886
//        Socket accept = serverSocket.accept();  // 监听客户端的连接，一旦有客户端连接，则会返回客户端对应的accept
//
//        InputStream in = accept.getInputStream();   //获取到客户端的输出流
//        byte b[] = new byte[1024];
//        int len = in.read(b);
//        System.out.println("接受到客户端数据,返回数据"+new String(b,0,len));
//
//        OutputStream out = accept.getOutputStream();  // 给客户端发送消息
//        out.write("服务端已经接受".getBytes());
//
//        serverSocket.close();
//    }
//}


public class SocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4569); // 建立服务端，ip为本机ip,端口为8886
        int i=4;
        while(i>2){
            Socket accept = serverSocket.accept(); // 监听客户端的连接，一旦有客户端连接，则会返回客户端对应的accept

            ServerThread st = new ServerThread(accept);   // 创建Runnable对象,通过实现Runable接口的类中的构造方法创建实例
            Thread th = new Thread(st);                   // 实例化一个线程对象,创建新线程
            th.start();                                   // 启动运行线程
            i++;
        }
        serverSocket.close();
    }
}