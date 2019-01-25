package highJava;

import java.util.*;

public class GenericityTest {
    public static void main(String[] args){
//        Integer[] intArray = {1,2,3,4,5};
//        Double[] doubleArray = {1.1,2.2,3.3,4.4,5.5};
//        Character[] charArray = {'H','E','L','L','O'};
//        System.out.print("整型数组元素：");
//        printArray(intArray);
//        System.out.print("双精度数组元素：");
//        printArray(doubleArray);
//        System.out.print("字符型数组元素：");
//        printArray(charArray);

        List<String> name = new ArrayList<String>();
        List<Integer> age = new ArrayList<Integer>();
        List<Number> number = new ArrayList<Number>();

        name.add("icon");
        age.add(18);
        number.add(314);

        getData(name);
        getData(age);
        getData(number);

    }

//  使用泛型方法打印不同类型数组中的元素
    public static <E> void printArray(E[] inputArray){
        for (E element : inputArray) {
            System.out.printf("%s ",element);
        }
        System.out.println();
    }
//  使用类型通配符一般是?来代替具体的类型参数,种类List<?>就是指List<String>等这些类型的数据
    public static void getData(List<?> data){
        System.out.println("data:"+data.get(0));
    }

}

