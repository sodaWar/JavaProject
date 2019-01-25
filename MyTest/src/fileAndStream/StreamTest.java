package fileAndStream;

import java.io.*;
//  由于这种写入是二进制写入,会存在乱码,所以需要指定编码,具体实例请看第2个文件
public class StreamTest {
    public static void main(String[] args){
        try {
            byte b[] = {1,3,5,16,27,57};
            OutputStream os = new FileOutputStream("stream.txt");
            for (int x=0; x<b.length; x++){
                os.write(b[x]);
            }
            os.close();
            InputStream is = new FileInputStream("stream.txt");
            int size = is.available();
            for (int i=0;i<size;i++){
                System.out.print((char)is.read()+ " ");
            }
            is.close();

        }catch (IOException e){
            System.out.print("");
        }

    }
}
