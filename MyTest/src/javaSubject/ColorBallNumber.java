package javaSubject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

public class ColorBallNumber {
    public static void main(String[] args) {
        HashMap<String, Integer> words = new HashMap<>();
        Scanner in = new Scanner(System.in);
        String word;
        while (!((word = in.nextLine()).equals(""))) {                                                                  //如果输入为空的时候终止输入
            int count = 1;                                                                                              //默认一个单词就是出现一次
            if (words.containsKey(word)) {                                                                              //判断刚输入的单词是否已经存在
                count = words.get(word) + 1;                                                                            //如果已经存在，新的个数就在已有的个数上加1
            }
            words.put(word, count);                                                                                     //插入新的数据
        }
        in.close();

        System.out.println("total have " + words.size() + " unique words");
        //遍历hashmap,遍历方式较list要麻烦一点,但是功能更丰富,这里entrySet是键-值对的集合,Map.Entry是Map的一个内部接口,该接口是泛型,它表示Map中的一个实体(一个key-value对),接口中有getKey(),getValue方法
        Iterator<Entry<String, Integer>> iterator = words.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<String, Integer> entry = (Entry<String, Integer>) iterator.next();
            System.out.println("you input \"" + entry.getKey() + "\" " + entry.getValue() + " times");
        }
    }
}
