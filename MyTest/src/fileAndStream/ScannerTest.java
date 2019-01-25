package fileAndStream;

import java.util.Scanner;
import java.io.File;

public class ScannerTest {
    public static void main(String[] args){
        /*
        Scanner sca = new Scanner(System.in);
        System.out.println("next方式接收:");
        if (sca.hasNextLine()){
            String str1 = sca.nextLine();
            System.out.print("输入的数据为"+str1);
        }
        sca.close();
        int a = sca.nextInt();
        System.out.print(a);
        */
//        catalogue();
        catalogue2();
    }

    public static void catalogue(){
        String dirname = "/test1/test2/test3";
        File d = new File(dirname);
        d.mkdirs();
    }

    public static void catalogue2(){
        String dirname = "/";
        File f = new File(dirname);
        String s[] = f.list();
        for (int i =0;i<s.length;i++){
//            这里注意,如果根目录不是"/"而是一个文件目录,如"/MyDrivers",那么需要在访问其子文件列表时加"/",改为dirname + "/" + s[i]
            File f1 = new File(dirname + s[i]);
            if (f1.isDirectory()) {
                System.out.println(s[i] + " 是一个目录");
            } else {
                System.out.println(s[i] + " 是一个文件");
            }
        }
    }

}
