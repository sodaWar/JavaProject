package javaExample;
import java.util.Scanner;

public class TowerofHanoi {
    static int m =0;//标记移动次数
    //实现移动的函数
    public static void move(int disks,char N,char M)
    {
        System.out.println("第" + (++m) +" 次移动 : " +" 把 "+ disks+" 号圆盘从 " + N +" ->移到->  " + M);
    }
    //递归实现汉诺塔的函数
    public static void hanoi(int n,char A,char B,char C)
    {
        if(n == 1)//圆盘只有一个时，只需将其从A塔移到C塔
            TowerofHanoi.move(1, A, C);//将编号为1的圆盘从A移到C
        else
        {
            /* 这里理解的话可以用圆盘数2和3来理解,圆盘2的话第一次移动是把1号圆盘从A移到B,圆盘3的话第一次移动是把1号圆盘从A移动C,这里只要是偶数第一次都是跟2的情况一样,奇数都跟3的情况一样
            原因是2的时候,是以hanoi(1,A,C,B)运行的,这里hanoi方法的形参B和C,它们的实参是C和B,所以运行TowerofHanoi.move(1, A, C)的结果是从A到B,而3是先运行hanoi(2,A,C,B),然后该函数运行之后又先去
            运行hanoi(1,A,C,B),而这里运行hanoi(2,A,C,B)的时候,实参是2,A,C,B,而不是A,B,C,所以再次运行hanoi(1,A,C,B)时的实参实际上是B和C,所以第一次是从A到C,这里只是理解第一次移动的情况
            接下来的移动就以圆盘3为例子最好理解,圆盘3是从最后n为2开始理解,hanoi(2-1,A,C,B)为第一次移动的情况,然后执行TowerofHanoi.move(2, A, C),这里C是形参,实参是B,所以第2次移动是把2号圆盘从A移到B
            然后执行hanoi(2-1,B,A,C),注意这些函数的形参都是为了说明一个函数,如A,C,B是为了说明将char B和char C的参数B和C的位置调换,然后再传入hanoi函数中,所以这里执行的B,A,C形参的实参是以上面函数A,C,B的实参,
            再次将A和B形参互换后的实参是C,A,B,所以第3次移动是把1号圆盘从C移到B.
            以上是第1次到第3次移动时,即算是执行完了hanoi(3-1,A,C,B)的代码,然后执行TowerofHanoi.move(3, A, C)就是第4次移动,把3号圆盘从A移动到C
            最后执行hanoi(3-1,B,A,C)即是第5次到第7次移动,理解方式和之前一样
            */
            hanoi(n - 1, A, C, B);//递归,把A塔上编号1~n-1的圆盘移到B上,以C为辅助塔
            TowerofHanoi.move(n, A, C);//把A塔上编号为n的圆盘移到C上
            hanoi(n - 1, B, A, C);//递归,把B塔上编号1~n-1的圆盘移到C上,以A为辅助塔
        }
    }
    public static void main(String[] args) {
        Scanner imput = new Scanner(System.in);
        char A = 'A';
        char B = 'B';
        char C = 'C';
        System.out.println("******************************************************************************************");
        System.out.println("这是汉诺塔问题（把A塔上编号从小号到大号的圆盘从A塔通过B辅助塔移动到C塔上去");
        System.out.println("******************************************************************************************");
        System.out.print("请输入圆盘的个数：");
        int disks = imput.nextInt();
        TowerofHanoi.hanoi(disks, A, B, C);
        System.out.println(">>移动了" + m + "次，把A上的圆盘都移动到了C上");
        imput.close();
    }

}
