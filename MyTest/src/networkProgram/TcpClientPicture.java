package networkProgram;

import java.net.*;
import java.io.*;

public class TcpClientPicture {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket socket = new Socket("127.0.0.1", 5555);
        // public BufferedInputStream(InputStream in,int size)是BufferedInputStream类的构造方法,默认缓冲区大小构造缓冲输入流对象,in是底层输入流,size是缓冲区大小
        // 构造一个字节缓冲输入流对象
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("c.jpg"));

        BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());

        byte b[] = new byte[1024];
        int len = 0;

        while ((len = in.read(b)) != -1) {
            out.write(b, 0, len);
            out.flush();    // 刷新缓冲区 要不然最后一块缓冲区字符串会缺失
        }

        socket.shutdownOutput();   // 关闭流以后Server段才会接收道结束字符结束接受

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        in.close();
        socket.close();

    }

}