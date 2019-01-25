package javaExample;

public class JavaPrintGraphEx {
        public static void main(String[] args) {
//            print(5,8);
//            print2(3);
//            print4();
//            print5();
            print6(6);
        }

        // 打印自定义长和宽的长方形
        private static void print(int L, int W) {
            for(int i= 1;i<=L;i++){
                for(int j=1;j<=W;j++){
                    System.out.print("*");
                }
                System.out.println();
            }
        }

        // 打印倒立的三角形
        public static void print2(int k){
            for (int m = 1; m <= k; m++) {
                //打印空格
                for (int n = 0; n <= m; n++) {
                    System.out.print(" ");
                }
                //打印*
                for (int x = 1; x <= 2*k - 1 -2 * (m - 1); x++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }

        // 打印九九乘法表
        public static void print3(){
            for(int i=1;i<=9;i++) {
                for(int j=1;j<=i;j++) {
                    System.out.print(j+"×"+i+"="+i*j+"\t");                                                             // 这里\t表示跳到下一个TAB位置
                }
                System.out.println();
            }
        }

        // 打印正立的三角形
        public static void print4(){
            for(int i=1;i<=5;i++){
                for(int j=5; i<=j; j--)
                    System.out.print(" ");
                for (int x = 1; x <= 2*i-1; x++) {
                    System.out.print("*");
                }
                // 这里跟以上一行代码输出*的效果是相同的,只不过思路不同,上面是一行*全部输出,下面是一行*分左边和右边输出.
//                for(int j=1; j<=i; j++)
//                    System.out.print("*");
//                for(int j=1; j<i; j++)
//                    System.out.print("*");
                System.out.println();
            }
        }

        // 打印平行四边形
        public static void print5(){
            //外层循环 每次打出一个*
            for (int i = 1; i <=5; i++) {
                //填充空格
                for (int j = 1; j <= 5 - i; j++) {
                    System.out.print(" ");
                }
                //内层循环 每次打印一个*,这里单独打印出来就是一个长方形,而上面填充空格作用就是将长方形变成平行四边形
                for (int k = 1; k <= 5; k++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }

        // 打印菱形
        public static void print6(int size) {
            if (size % 2 == 0) {
                size++;                                                                                                 // 计算菱形大小
            }
            for (int i = 0; i < size / 2 + 1; i++) {
                for (int j = size / 2 + 1; j > i + 1; j--) {
                    System.out.print(" ");                                                                              // 输出左上角位置的空白
                }
                for (int j = 0; j < 2 * i + 1; j++) {
                    System.out.print("*");                                                                              // 输出菱形上半部边缘
                }
                System.out.println();                                                                                   // 换行
            }
            for (int i = size / 2 + 1; i < size; i++) {
                for (int j = 0; j < i - size / 2; j++) {
                    System.out.print(" ");                                                                              // 输出菱形左下角空白
                }
                for (int j = 0; j < 2 * size - 1 - 2 * i; j++) {
                    System.out.print("*");                                                                              // 输出菱形下半部边缘
                }
                System.out.println();                                                                                   // 换行
            }
        }

}
