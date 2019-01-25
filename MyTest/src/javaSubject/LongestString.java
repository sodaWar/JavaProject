package javaSubject;

public class LongestString {
    public static void main(String[] args){
        calMaxLength();
//        String str1 = new String("abcdabce");
//        char[] chr1 = str1.toCharArray();
//        for (int i =0;i<str1.length();i++){
//            for (int x=1;x<str1.length();x++){
//                while (compareSize(chr1[i],chr1[x]) == -1){
//                    if(recursion(chr1,x)!=x){
//                        System.out.println(i + "  " + recursion(chr1,x));
//                        break;
//                    }else {
//                        System.out.print(1);
//                    }
//                }
//            }
    }

    public static void calMaxLength() {

        String input = "adca";
        int max=0;
        int temp=1;

        /**
         * 对整个string进行遍历
         */
        for(int i=1;i<input.length();i++){
            char pre = input.charAt(i-1);
            char now = input.charAt(i);
            if(now-pre==1){//如果是连续字符串，长度加一
                temp++;
            }else{//如果不是连续的字符串,对之前连续的字符串长度进行判断,看是不是目前最长的,如果是则保存
                //并且长度计算长度重新计为1
                max=(max>temp?max:temp);
                temp=1;
            }
        }
        //因为上面的程序没有对最后一次连续长度进行比较,所以在这里额外比较一次
        max=(max>temp?max:temp);

        //题目要求没有连续的输出0,即没有1这个说法,所以这里进行了判断
        System.out.println((max==1?0:max));

    }


    public static int recursion(char[] chr1,int x){
        int y = 0;
        if(compareSize(chr1[x],chr1[x+1]) == -1){
            y = x +1;
            recursion(chr1,y);
            return y+1;
        }else {
            return x;
        }
    }

    public static int compareSize(char a,char b){
        if(a>b)
            return 1;
        else
            return -1;
    }

}
