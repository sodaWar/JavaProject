package javaExample;

import java.util.*;
import java.lang.*;

public class JavaStringEx {
    public static void main(String[] args){
        /*
        String str = "Hello World";
        String anotherString = "hello world";
        Object str1 = str;
        // compareTo方法有两种比较方式,一种是int compareTo(Object o)字符串与对象进行比较,o是要比较的对象;一种是int compareTo(String anotherString)按字典顺序比较两个字符串;
        // 该方法比较对应字符的大小(ASCII码顺序),如果此字符串小于字符串参数,则返回一个小于0的值;相等返回0;如果两个字符数组的长度不一样,并且较短的数组和较长数组所有对应位置的字符都相同,则返回两个数组的长度之差
        System.out.println( str.compareTo(anotherString) );
        System.out.println( str.compareToIgnoreCase(anotherString) );  //忽略大小写
        System.out.println( str.compareTo(str1.toString()));

        // 通过strOrig.lastIndexOf(Stringname)来查找子字符串Stringname在strOrig最后出现的位置
        String strOrig = "Hello world ,Hello Runoob";
        int lastIndex = strOrig.lastIndexOf("o");
        if(lastIndex == - 1){
            System.out.println("没有找到字符串 Runoob");
        }else{
            System.out.println("Runoob 字符串最后出现的位置： "+ lastIndex);
        }

        // String类的replace方法可用来替换字符串中的字符
        String str2="Hello World";
        System.out.println( str2.replace( 'H','W' ) );
        System.out.println( str2.replaceFirst("He", "Wa") );
        System.out.println( str2.replaceAll("He", "Ha") );

        // 使用java的反转函数reverse()将字符串反转
        String string="runoob";
        String reverse = new StringBuffer(string).reverse().toString();
        System.out.println("字符串反转前:"+string);
        System.out.println("字符串反转后:"+reverse);

        // 使用String类的toUpperCase()方法将字符串从小写转为大写,toLowerCase方法将大写转为小写
        String str3 = "string runoob";
        String strUpper = str3.toUpperCase();
        String strUpper2 = strUpper.toLowerCase();
        System.out.println("原始字符串: " + str3);
        System.out.println("转换为大写: " + strUpper);
        System.out.println("转换为小写: " + strUpper2);

        // 使用String 类的indexOf()方法在字符串中查找子字符串出现的位置,如果存在返回字符串第一次出现的位置,该方法是第一次出现的位置,lastIndexOf方法是最后一次出现的位置
        String strOrig2 = "Google Runoob Taobao";
        int intIndex = strOrig2.indexOf("oo");
        if(intIndex == - 1){
            System.out.println("没有找到字符串 Runoob");
        }else{
            System.out.println("Runoob 字符串位置 " + intIndex);
        }

        // 使用regionMatches()方法测试两个字符串区域是否相等,match1的表达式意思是将first_str字符串从第11个字符"M"开始和 second_str 字符串的第12个字符"M"开始逐个比较,共比较9对字符
        String first_str = "Welcome to Microsoft";
        String second_str = "I work with microsoft";
        boolean match1 = first_str.regionMatches(11, second_str, 12, 9);
        boolean match2 = first_str.regionMatches(true, 11, second_str, 12, 9); //第一个参数 true 表示忽略大小写区别
        System.out.println("区分大小写返回值：" + match1);
        System.out.println("不区分大小写返回值：" + match2);

        // 通过substring()函数来删除字符串中的一个字符,我们将功能封装到removeCharAt函数中
        String str4 = "this is Java";
        System.out.println(removeCharAt(str4, 3));

        // 使用split(string)方法通过指定分隔符将字符串分割为数组
        String str5 = "www-runoob-com";
        String[] temp;
        String delimeter = "-";  // 指定分割字符
        temp = str5.split(delimeter); // 分割字符串
        // 普通 for 循环
        for(int i =0; i < temp.length ; i++){
            System.out.println(temp[i]);
            System.out.println("");
        }

        System.out.println("------java for each循环输出的方法-----");
        String str6 = "www.runoob.com";
        String[] temp1;
        String delimeter1 = "\\.";  // 指定分割字符， . 号需要转义
        temp1 = str6.split(delimeter1); // 分割字符串
        for(String x :  temp1){
            System.out.println(x);
            System.out.println("");
        }

        // 通过调用StringTokenizer方法来分隔字符串,该方法与split方法的区别在于,前者会以给定分割字符串的每个字符进行分割,而后者是以整个字符串进行切割
        // 如以el分隔字符串,StringTokenizer分割原理是:只要有字符e和l的地方都进行切割,而split是只在字符串el的地方切割。
        String str7="www.runoob.com";
        // 实例化一个StringTokenizer对象,并指向以.对str进行分割
        StringTokenizer str8=new StringTokenizer(str7, ".");
        // 通过hasMoreTokens()与nextToken()进行判断并打印分割后的子字符串,对str8遍历并打印子字符串
        while(str8.hasMoreTokens()){
            System.out.println(str8.nextToken());
        }

        // intern()方法返回字符串对象的规范化表示形式,字符串赋值的两种方式比较
        String variables[] = new String[50000];
        long startTime0 = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            variables[i] = "hello";
        }

        long endTime0 = System.currentTimeMillis();
        System.out.println("使用字面量直接赋值字符串，花费时间：" + (endTime0 - startTime0) + "毫秒");
        String variables1[] = new String[50000];
        long startTime1 = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            variables1[i] = new String("hello");
        }

        long endTime1 = System.currentTimeMillis();
        System.out.println("使用字符串对象花费时间：" + (endTime1 - startTime1) + "毫秒");
        String variables2[] = new String[50000];
        long startTime2 = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            variables2[i] = new String("hello");
            variables2[i] = variables2[i].intern();
        }

        long endTime2 = System.currentTimeMillis();
        System.out.println("使用字符串对象intern()方法花费时间：" + (endTime2 - startTime2) + "毫秒");

        // String类的format()方法用于创建格式化的字符串以及连接多个字符串对象,不同转换符实现不同数据类型到字符串的转换,如%s是字符串类型,%f是浮点类型,%n是换行,%d是整型,%c是字符类型,%b布尔类型等
        double e = Math.E;
        System.out.format("%f%n", e);

        // 字符串拼接可使用+或StringBuilder类的append()方法,其实+拼接底层也是使用了StiringBuilder来拼接,用+拼接的性能在循环使用时就会慢的很多
        // 如str = str + "a",编译器会处理为new StringBuilder().append(str).append("a"),只要+拼接全部在一条语句中,就会new一次,后面一直调用append,一旦另起一条语句就会new一个新的StringBuilder

        long startTime = System.currentTimeMillis();
        for(int i=0;i<5000;i++){
            String result = "This is"
                    + "testing the"
                    + "difference"+ "between"
                    + "String"+ "and"+ "StringBuffer";
        }
        long endTime = System.currentTimeMillis();
        System.out.println("字符串连接"
                + " - 使用 + 操作符 : "
                + (endTime - startTime)+ " ms");
        long startTime1 = System.currentTimeMillis();
        for(int i=0;i<5000;i++){
            StringBuffer result2 = new StringBuffer();
            result2.append("This is");
            result2.append("testing the");
            result2.append("difference");
            result2.append("between");
            result2.append("String");
            result2.append("and");
            result2.append("StringBuffer");
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("字符串连接"
                + " - 使用 StringBuffer : "
                + (endTime1 - startTime1)+ " ms");
*/

    }

    private static String removeCharAt(String s,int num){
        return s.substring(0,num) + s.substring(num+1);
    }

}
