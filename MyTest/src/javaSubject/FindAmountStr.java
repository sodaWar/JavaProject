package javaSubject;

public class FindAmountStr {
    public static void main(String[] args){
        String str1 = "abcdefghijklmn";
        String str2 = "cde";
        String str3 = "kl";
        int num1,num2=0;
        if (str1.indexOf(str2) < str1.indexOf(str3)){
            num1 = str1.indexOf(str2) + str2.length();
            num2 = str1.indexOf(str3);
        }else {
            num1 = str1.indexOf(str3) + str3.length();
            num2 = str1.indexOf(str2);
        }

        String str4 = str1.substring(num1,num2);
        System.out.println(str4);
    }

}
