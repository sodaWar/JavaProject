package networkProgram;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

// 使用Socket类的accept()方法和ServerSocket类的MultiThreadServer(socketname)方法来实现多线程服务器程序
public class JavaSocketThread implements Runnable {
    Socket csocket;
    JavaSocketThread(Socket csocket) {
        this.csocket = csocket;
    }

    public static void main(String args[])throws Exception {
        ServerSocket ssock = new ServerSocket(1234);
        System.out.println("Listening");
        while (true) {
            Socket sock = ssock.accept();
            System.out.println("Connected");
            new Thread(new JavaSocketThread(sock)).start();                                                             // 这里是启动多线程的关键代码,新启动一个线程,具体理解看SocketServer.java文件中启动线程的注释
        }
    }
    public void run() {
        try {
            // 获取输出流（服务端输出流即向客户端输出信息）,这里是创建一个PrintStream实例并在构造方法中传入OutputStream,PrintStream类可以将格式化数据写入到OutputStream底层
            PrintStream pstream = new PrintStream(csocket.getOutputStream());
            for (int i = 100; i >= 0; i--) {
                pstream.println("NO." + i + " connect user");                                                           // 打印基本类型的数据
            }
            pstream.close();                                                                                            // 关闭流
            csocket.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}
