import java.io.*;

// 使用FileOutputStream类来截取视频,只能是操作视频的字节数来达到截取的目的,因为该类写入文件是以二进制文件形式写入,所以只能操作字节,不能根据视频时间段来操作
public class MusicCompound
{
    public static void main(String args[])
    {
        FileOutputStream fos = null;
        FileInputStream fis = null;
        String fileNames[] = {"D:/约定.mp3","D:/谁明浪子心.mp3"};
        //设置byte数组，每次往输出流中传入8K的内容
        byte by[] = new byte[1024*8];
        try
        {
            fos = new FileOutputStream("D:/合并.mp3");
            for(int i=0;i<2;i++)
            {
                int count = 0;
                fis = new FileInputStream(fileNames[i]);
                //跳过前面3M的歌曲内容,这里注意1024*1024字节是1M,1024字节是1KB,FileInputStream类的skip方法可以跳过特定字节长度的音频文件
                fis.skip(1024*1024*4);
//                读取剩下的音频字节的数据,返回-1则代表读取到结尾了,这里的read方法是int read(byte[] r)函数,该方法从输入流读取r.length长度的字节,返回读取的字节数
                while(fis.read(by) != -1)
                {
                    fos.write(by);
                    count++;
                    System.out.println(count);
                    //要截取中间2MB的内容，每次输入8k的内容，所以输入的次数是1024*2/8
                    if(count == (1024*2/8))
                    {
                        break;
                    }
                }
            }
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //输出完成后关闭输入输出流
                fis.close();
                fis.close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}