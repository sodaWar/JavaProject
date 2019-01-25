package networkProgram;

import java.net.*;
import java.io.*;

public class TcpServerPicture {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(5555);
        Socket ss = serverSocket.accept();

        BufferedInputStream br = new BufferedInputStream(ss.getInputStream());

        BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream("copy.jpg"));  // 写出文件流

        byte b[] = new byte[1024];
        int len = 0;

        while ((len = br.read(b)) != -1) {   // 写出文件
            bw.write(b, 0, len);
            bw.flush();  // 别忘了刷新，要不然最后一块缓冲区字符串会缺失
        }

        BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(ss.getOutputStream())); // 输出
        bw2.write("图片传输成功");
        bw2.flush();

        bw.close();
        ss.close();
    }

}
