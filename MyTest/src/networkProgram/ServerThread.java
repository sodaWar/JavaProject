package networkProgram;

import java.net.*;
import java.io.*;

public class ServerThread implements Runnable {
    private Socket accept;
    ServerThread(Socket s) {
        this.accept = s;
    }
    public void run(){
        InputStream in;
        try {
            in = accept.getInputStream();
            byte b[] = new byte[1024];
            int len = in.read(b);
            System.out.println("接受到客户端数据,返回数据" + new String(b, 0, len));
            OutputStream out = accept.getOutputStream(); // 给客户端发送消息
            out.write("服务端已经接受".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}