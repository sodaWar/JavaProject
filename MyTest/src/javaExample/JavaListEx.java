package javaExample;
import java.util.*;
import java.io.*;

public class JavaListEx{
    public static void main(String args[])throws IOException{
        /*
        // 数组转集合
        int n = 5;
        String[] name = new String[n];
        for(int i = 0; i < n; i++){
            name[i] = String.valueOf(i);
        }
        // 使用Java Util类的Arrays.asList(name)方法将数组转换为集合,但是该方法返回的一个ArrayList类型的对象,是不能做任何内部元素的添加、更新、删除操作
        List<String> list = Arrays.asList(name);
        // 所以如果需要做增减等操作,建议以上一行代码改为List<String> levelList = new ArrayList<String>(Arrays.asList(name));
        for(String li: list){
            String str = li;
            System.out.print(str + " ");
        }


        // 将字符串转换为集合并使用Collection 类的Collection.min()和Collection.max()来比较集合中的元素
        String[] coins = { "Penny", "nickel", "dime", "Quarter", "dollar" };
        Set<String> set = new TreeSet<String>();
        for (int i = 0; i < coins.length; i++) {
            set.add(coins[i]);
        }
        // min方法中只传入集合,则是按照默认自然排序方式取得最小值
        System.out.println(Collections.min(set));
        // 传入一个比较器Comparator可以定制比较,这里String.CASE_INSENSITIVE_ORDER比较器的作用是,先按照字符串长度取短的那个字符串的长度作为条件,然后循环判断两个字符串的第一个字符的ASCII码大小,做出递增排序
        // 所以该方法是将字符串通过首字母的ASCII码进行排序
        System.out.println(Collections.min(set, String.CASE_INSENSITIVE_ORDER));
        for (int i = 0; i <= 10; i++) {
            System.out.print("-");
        }
        System.out.println("");
        System.out.println(Collections.max(set));
        System.out.println(Collections.max(set, String.CASE_INSENSITIVE_ORDER));

        // 使用Collection 类的iterator()方法来遍历集合
        HashMap< String, String> hMap = new HashMap< String, String>();
        hMap.put("1", "1st");
        hMap.put("2", "2nd");
        hMap.put("3", "3rd");
        Collection cl = hMap.values();
        Iterator itr = cl.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        // 使用Collections类的collection.add()来添加数据并使用collection.size()来计算集合的长度
        int size;
        HashSet collection = new HashSet ();
        String str1 = "Yellow", str2 = "White", str3 = "Green", str4 = "Blue";
        Iterator iterator;
        collection.add(str1);
        collection.add(str2);
        collection.add(str3);
        collection.add(str4);
        System.out.print("集合数据: ");
        iterator = collection.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        size = collection.size();
        if (collection.isEmpty()){
            System.out.println("集合是空的");
        }
        else{
            System.out.println( "集合长度: " + size);
        }
        System.out.println();

        // 使用Collections.shuffle()方法可打乱集合元素的顺序,使用方法是Collections.shuffle(list);之后list中的元素就被打乱了,输出list即可查看

        // 使用collection.reverse()方法来反转集合中的元素,使用Collections类的max()和min()方法来获取List中最大最小值,如Collections.max(list)
        // 使用collection.remove("a")方法来删除集合中的指定元素,a为删除的元素值;Collections.unmodifiableList(set)方法可设置集合为只读,set为集合
        String[] coins = { "A", "B", "C", "D", "E" };
        List l = new ArrayList();
        for (int i = 0; i < coins.length; i++)
            l.add(coins[i]);
        ListIterator liter = l.listIterator();
        System.out.println("反转前");
        while (liter.hasNext())
            System.out.println(liter.next());
        Collections.reverse(l);
        liter = l.listIterator();
        System.out.println("反转后");
        while (liter.hasNext())
            System.out.println(liter.next());

        // 使用Collections类的rotate()来循环移动元素,方法第二个参数指定了移动的起始位置;split 方法将一个字符串分割为子字符串,然后将结果作为字符串数组返回;asList()将数组转换为List集合
        // 使用Collections类的replaceAll()来替换List中所有的指定元素,如以下list中所有one的字符都被替换成first了
        // 使用Collections类的indexOfSubList()和lastIndexOfSubList()方法来查看子列表是否在列表中,并查看子列表在列表中所在的位置
        List list = Arrays.asList("one Two three Four five six".split(" "));
        System.out.println("List :"+list);
        Collections.rotate(list, 3);
        System.out.println("rotate: " + list);
        Collections.replaceAll(list, "one", "first");
        System.out.println("replaceAll: " + list);
        List sublist = Arrays.asList("three Four".split(" "));
        System.out.println("子列表 :"+sublist);
        System.out.println("indexOfSubList: "+ Collections.indexOfSubList(list, sublist));
        System.out.println("lastIndexOfSubList: " + Collections.lastIndexOfSubList(list, sublist));


        // 使用Hashtable类的keys()方法来遍历输出键值,这里使用Enumeration类的hasMoreElements和nextElement方法来遍历输出HashTable中的内容,枚举类的使用注意下！
        Hashtable ht = new Hashtable();
        ht.put("1", "One");
        ht.put("2", "Two");
        ht.put("3", "Three");
        Enumeration e = ht.keys();
        while (e.hasMoreElements()){
            System.out.println(e.nextElement());
        }
        // LinkedList、ArrayList、HashSet、TreeSet、LinkedHashSet集合添加元素使用add()方法;HashMap、TreeMap、LinkedHashMap集合添加元素使用put()方法
*/

    }
}