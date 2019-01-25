package javaSubject;

public class HumpDelete {
    public static void main(String[] args){
        // 删除驼峰之间的字符
        String str = "badcan";
        StringBuffer str1 = new StringBuffer("badcan");
        HumpDelete hd = new HumpDelete();
        int[] a = hd.findDuplicate(str);
        for (int b:a) {
            System.out.println(b);
        }
        StringBuffer str3 = str1.delete(a[1]+1,a[0]);
        System.out.print(str3);
    }

    public int[] findDuplicate(String str) {
        char[] chr = str.toCharArray();
        for (int i = 0; i < chr.length; i++) {
            for (int x = i+1;x<chr.length;x++){
                if (chr[i] == chr[x]){
                    int[] y = new int[]{x,i};
                    return y;
                }
            }
        }
        System.out.print("该字符串无重复元素");
        int[] a = new int[]{0,0};
        return a;
    }
}
