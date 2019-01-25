package javaSubject;
import java.util.*;
// 数组去重的所有方法

public class NumberDeWeight {
    public static void main(String[] args){
        /*
        // 使用Set集合自动去除重复元素
        Integer[] arr = {85,4,2,6,11,4,5,8,9};
        Set<Integer> set = new HashSet<Integer>();
        for(Integer i : arr)
            set.add(i);
        for(Object j: set.toArray())
            System.out.print(j + " ");


        // 先遍历原数组,然后遍历结果集,通过比对后相同则break,不同则存入结果集
        String[] array = {"a","b","c","c","d","e","e","e","a"};
        List<String> result = new ArrayList<>();
        boolean flag;
        for(int i=0;i<array.length;i++){
            flag = false;
            for(int j=0;j<result.size();j++){
                if(array[i].equals(result.get(j))){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                result.add(array[i]);
            }
        }
        String[] arrayResult = (String[]) result.toArray(new String[result.size()]);
        System.out.println(Arrays.toString(arrayResult));


        // 通过使用indexOf方法进行判断结果集中是否存在了数组元素
        String[] array = {"a","b","c","c","d","e","e","e","a"};
        List<String> list = new ArrayList<>();
        list.add(array[0]);
        for(int i=1;i<array.length;i++){
            if(list.toString().indexOf(array[i]) == -1){                                                                // 这里是ArrayList类的toString()方法,作用是将集合内的数据转换成字符串形式,然后才能使用indexOf()方法
                list.add(array[i]);
            }
        }
        // 这里toString()方法返回一个字符串,Arrays的toString方法是返回指定数组内容的字符串表示形式;两者是重名函数关系,没有复写,两者的区别好比羊喝水和你喝水一样,虽然都是喝水,但主体不同
        String[] arrayResult = (String[]) list.toArray(new String[list.size()]);                                        // 这里是将list集合转换为数组,这是toArray()方法的第二种使用形式
        System.out.println(Arrays.toString(arrayResult));                                                               // Arrays.toString()方法将一个数组转换成字符串,该方法按顺序把多个数组元素连接在一起,多个元素之间使用逗号和空格隔开


        // 嵌套for循环进行比较
        String[] array = {"a","b","c","c","d","e","e","e","a"};
        List<String> list = new ArrayList<>();
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i] == array[j]){
                    j = ++i;
                }
            }
            list.add(array[i]);
        }
        String[] arrayResult = (String[]) list.toArray(new String[list.size()]);
        System.out.println(Arrays.toString(arrayResult));

        // 先使用java提供的数组排序方法进行排序,然后进行一层for循环,进行相邻数据的比较即可获得最终结果集
        String[] array = {"a","b","c","c","d","e","e","e","a"};
        Arrays.sort(array);
        List<String> list = new ArrayList<>();
        list.add(array[0]);
        for(int i=1;i<array.length;i++){
            if(!array[i].equals(list.get(list.size()-1))){
                list.add(array[i]);
            }
        }
        String[] arrayResult = (String[]) list.toArray(new String[list.size()]);
        System.out.println(Arrays.toString(arrayResult));


        // 使用getRepeateNum()函数的算法步骤实现重复元素的查找
        Scanner scanner = new Scanner(System.in);
        int[] num = new int[10];                                                                                        //数组长度可以自己定义
        System.out.println("请输入一组数据：");
        for(int i = 0; i < 10; i++) {
            num[i] = scanner.nextInt();
        }
        getRepeateNum(num);
        */

        // 使用hashmap找出每个字母重复的数量方法
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        String str="afashfjgjkhlnmash,^566*整数gshkjshgksdfsgdfhjk";
        for (int i=0;i<str.length();i++) {
            char c = str.charAt(i);
            String key = String.valueOf(c);
            if (map.containsKey(key)) {
                Integer value = map.get(key);
                map.put(key, value + 1);
            } else {
                //map.put(key, 1); 统计所有的字符，包括中文
                if (c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z') {//利用ascii码去除字符串的数字，空格，标点符号，特殊字符
                    map.put(key, 1);
                }
            }
        }
        System.out.println(map);

    }
        /*
        getRepeateNum()函数的算法步骤：
        1.当扫描到下表为i的数字时,首先比较这个数字(用m表示)是不是等于下标i
        2.如果是,则接着扫描下一个数字;如果不是,则再拿它和第m个数字进行比较
        3.如果它和第m个数字相等,就找到了一个重复的数字(也就是下标i和下标m的位置都出现了)
        4.如果它和第m个位置数字不相等,就把第i个数字和第m个数字交换
        5.接下来我们再重复这个比较和交换的过程,直到我们发现一个重复的数字
        */
    public static void getRepeateNum( int[] num) {
        int NumChange;
        System.out.println("重复数字是：");
        for(int index = 0; index < num.length; index++) {
            while(num[index] != index) {
                if(num[index] == num[num[index]]) {
                    System.out.print(num[index]+" ");
                    break;
                } else {
                    NumChange = num[num[index]];
                    num[num[index]] = num[index];
                    num[index] = NumChange;
                }
            }
        }
    }

}
