package highJava;

import java.util.*;

public class TraverseList {
    public static void main(String[] args){
//        traverseList2();
        traverseMap();
    }

    public static void traverseList2(){
        List<String> list = new ArrayList<String>();
        list.add("Hello");
        list.add("World");
        list.add("Java");
//      使用增强for遍历list
        for (String str: list) {
            System.out.print(str);
        }
//      把链表变为数组相关的内容进行遍历
        String[] strArray = new String[list.size()];
        list.toArray(strArray);                                                                                         // list转换为str数组的语法
        for (int i=0;i<strArray.length;i++){
            System.out.print(strArray[i]);
        }
//      使用迭代器遍历
        Iterator<String> ite = list.iterator();                                                                         // iterator方法返回一个Iterator类型的数据
        while (ite.hasNext()){
            System.out.print(ite.next());
        }
    }

    public static void traverseMap(){
        Map<String,String> map = new HashMap<String, String>();
        map.put("1","java");
        map.put("2","python");
        map.put("3","c++");
//      通过keySet()方法遍历key和value
        for (String key : map.keySet()) {                                                                               // keySet()方法返回值是Map中key值的Set集合
            System.out.print(" key="+key+" and value=" + map.get(key));
        }
//      通过entrySet()使用iterator遍历key和value
        Iterator<Map.Entry<String,String>> it = map.entrySet().iterator();                                              // entrySet()方法的返回值是一个Set集合,此集合类型是Map.Entry,所以这里迭代器的类型是Map.Entry
        while (it.hasNext()){
            Map.Entry<String,String> entry = it.next();
            System.out.print("key="+entry.getKey()+"and value="+entry.getValue());
        }
//      通过entrySet遍历key和value,推荐使用该方法,尤其是容量大时
        for (Map.Entry<String,String> entry :map.entrySet()) {
            System.out.print(" key="+entry.getKey()+" and value="+entry.getValue());
        }

        }
    }
