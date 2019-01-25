package highJava;

import java.io.*;

//public class SerializeTest {
//    public static void main(String[] args){
//        Employee e = new Employee();
//        e.name = "Tony";
//        e.address = "beijing";
//        e.number = 1734861;
////      使用ObjectOuputStream类来序列化对象,将Employee对象序列化到文件中
//        try {
//            FileOutputStream fileout = new FileOutputStream("D:/employee.ser");
//            ObjectOutputStream out = new ObjectOutputStream(fileout);
//            out.writeObject(e);
//            out.close();
//            fileout.close();
//            System.out.print("Serialized data is saved in employee.ser");
//        }catch (IOException i){
//            i.printStackTrace();
//        }
//    }
//}


public class SerializeTest {
    public static void main(String[] args){
        Employee e = null;
//      使用ObjectInputStream类来反序列化对象
        try {
            FileInputStream filein = new FileInputStream("D:/employee.ser");
            ObjectInputStream in = new ObjectInputStream(filein);
            e = (Employee) in.readObject();                                                                             // 注意,readObject()方法的返回值被转化为Employee引用,因为e是Employee类型,其值也必须是该类型
            in.close();
            filein.close();
        }catch (IOException i){
            i.printStackTrace();
            return;
        }catch (ClassNotFoundException c){
            System.out.print("Employee class not found");
            c.printStackTrace();
            return;
        }
        System.out.println("Name:"+e.name);
        System.out.println("Address:"+e.address);
        System.out.println("Number:"+e.number);
    }
}


class Employee implements java.io.Serializable{
    public String name;
    public String address;
    public int number;
    public void mailCheck(){
        System.out.print("check to "+name+" "+address);
    }
}
