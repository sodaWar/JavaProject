package javaExample;
import java.io.*;
import java.util.Date;

public class JavaFileOperateEx {
    // 该函数是获取文件大小,file.exists()判断文件目录是否存在,isFile()判断文件存在且是一个标准文件,length()方法获取文件大小,以字节计算
    public static long getFileSize(String filename) {
        File file = new File(filename);
        if (!file.exists() || !file.isFile()) {
            System.out.println("文件不存在");
            return -1;
        }
        return file.length();
    }
    public static void main(String[] args)  {
        long size = getFileSize("C:\\data\\test.txt");
        System.out.println("java.txt文件大小为: " + size);
        /*

        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("testFile.txt"));                           // 使用write()方法向文件写入内容
            BufferedReader in = new BufferedReader(new FileReader("testFile.txt"));                            // 使用readLine()方法来读取文件
            String str;
            out.write("hello world");
            out.close();
            System.out.println("文件创建成功！");
            while ((str = in.readLine()) != null){
                System.out.println(str);
            }
        } catch (IOException e) {
        }

        // 使用delete()方法将文件删除
        File file = new File("C:\\data\\test.txt");                                                 // 该方式创建File对象,如果该文件不存在不会自动创建
        if(file.delete()){
            System.out.println(file.getName() + " 文件已被删除！");
        }else{
            System.out.println("文件删除失败！");
        }

        // 向文件中追加数据,只需要在创建FileWriter对象时加入参数为true即可,代表不会替换原来文件内容,在结尾处追加
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("testFile.txt"));
            out.write("aString1\n");
            out.close();
            out = new BufferedWriter(new FileWriter("testFile.txt",true));
            out.write("aString2");
            out.close();
            BufferedReader in = new BufferedReader(new FileReader("testFile.txt"));
            String str;
            while ((str = in.readLine()) != null) {
                System.out.println(str);
            }
            in.close();
        }
        catch (IOException e) {
            System.out.println("exception occoured"+ e);
        }

        // 使用createTempFile(String prefix, String suffix, File directory)创建临时文件,参数prefix为前缀,suffix为后缀,directory为临时文件的目录
        File f = null;
        try {
            // 创建临时文件
            f = File.createTempFile("tmp", ".txt", new File("C:\\data"));
            // 输出绝对路径
            System.out.println("File path: "+f.getAbsolutePath());
            // 终止后删除临时文件
            f.deleteOnExit();
        } catch(Exception e) {
            // 如果有错误输出内容
            e.printStackTrace();
        }

        // 使用File类的oldName.renameTo(newName)方法来重命名文件
        File oldName = new File("C:\\data\\test.txt");
        File newName = new File("C:\\data\\test2.txt");
        if(oldName.renameTo(newName)) {
            System.out.println("已重命名");
        } else {
            System.out.println("Error");
        }
        // 使用File类的file.setReadOnly()和file.canWrite()方法来设置文件只读,以及setWritable(true)设置文件为可写入
        System.out.println(newName.setReadOnly());
        System.out.println(newName.canWrite());
        System.out.println(newName.setWritable(true));
        // 使用File类的file.lastModified()方法来获取文件最后的修改时间
        Long lastModified = newName.lastModified();
        Date date = new Date(lastModified);
        System.out.println(date);
        */

        // 使用File类的filename.compareTo(another filename)方法来比较两个文件路径是否在同一个目录下
        File file1 = new File("C:/File/demo1.txt");
        File file2 = new File("C:/java/demo1.txt");
        if(file1.compareTo(file2) == 0) {
            System.out.println("文件路径一致！");
        } else {
            System.out.println("文件路径不一致！");
        }
    }
}
