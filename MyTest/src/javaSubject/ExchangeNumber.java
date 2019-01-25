package javaSubject;
import java.util.Arrays;

public class ExchangeNumber {
    public static void main(String[] args){
        // 借助中间变量交换两个整数值
        int x = 10;
        int y = 20;
        int temp = x;
        x = y;
        y = temp;

        // 位移运算交换
        int a = 10;
        int b = 20;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        // 数值相加减交换
        int c = 10;
        int d = 20;
        c = c + d;
        d = c - d;
        c = c - d;
        exchange();

    }

    public static void exchange() {
        String arr = "Hello World";
        String s[] = arr.split(" ");
        // 实现倒序转换
        for(int j=0; j<s.length; j++){
            String temp = s[j];
            s[j] = s[s.length-1];
            s[s.length-1] = temp;
        }
        // 使用Array类输出数组内容
        System.out.printf("s倒序后的内容为"+ Arrays.toString(s) +"\n");
    }
}
