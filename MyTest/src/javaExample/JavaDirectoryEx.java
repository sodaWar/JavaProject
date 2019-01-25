package javaExample;
import java.io.File;

public class JavaDirectoryEx {
    public static void main(String[] args) {
        /*
        // 使用File类的mkdirs()实现递归创建目录
        String directories = "D:\\a\\b\\c\\d\\e\\f\\g\\h\\i";
        File file = new File(directories);
        boolean result = file.mkdirs();
        System.out.println("Status = " + result);

        // 使用递归删除目录中的所有文件,方法是在一个个删除文件后再删除目录
        File dir = new File("D:\\a\\b");
        deleteDir(dir);

        // 使用file.list()方法来判断目录是否为空
        File file = new File("./testApi");  //当前目录下的testApi目录
        if(file.isDirectory()){
            if(file.list().length>0){
                System.out.println("目录不为空!");
            }else{
                System.out.println("目录为空!");
            }
        }else{
            System.out.println("这不是一个目录!");
        }
        // 使用file.isHidden()方法来判断文件是否隐藏
        System.out.println(file.isHidden());


        // 使用dir.list()方法在指定目录中查找所有文件列表
        File dir = new File("D:\\tmp\\beihui\\test");
        String[] children = dir.list();
        if (children == null) {
            System.out.println("该目录不存在");
        }
        else {
            for (int i = 0; i < children.length; i++) {
                String filename = children[i];
                System.out.println(filename);
            }
        }

        // file.getParent()方法获取文件的上级目录,file.lastModified()方法可用来获取目录的最后修改时间
        File file = new File("D:\\jmeter.log");
        System.out.print(file.getParent());
        */

        showDir(1, new File("D:\\tmp"));
    }

    // 使用File类的file.getName()和file.listFiles()方法来打印目录结构
    static void showDir(int indent, File file){
        for (int i = 0; i < indent; i++)
            System.out.print('-');
        System.out.println(file.getName());
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++)
                showDir(indent + 4, files[i]);
        }
    }

    public static void deleteDir(File dir){

        //1.列出当前目录下的文件以及文件夹
        File[] files = dir.listFiles();

        //2.对该数组进行遍历
        for(File f:files){

            //3.判断是否有目录,如果有,继续使用该功能遍历,如果不是,文件夹直接删除
            if(f.isDirectory()){
                deleteDir(f);
            }else{
                System.out.println("File:"+f.getName()+f.delete());//文件删除
            }
        }

        System.out.println("Dir:"+dir.getName()+dir.delete());//最后删除文件夹

    }
}