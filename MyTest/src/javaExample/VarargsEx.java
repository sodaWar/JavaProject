package javaExample;

public class VarargsEx {
    // varargs功能是提供可变长度的参数,定义的方式是在形参的类型和参数名之间加上...即可,就可以让它和不确定个数的实参相匹配
    // 使用varargs作为方法定义的参数,可以传递数组或参数序列,如果传递了一系列参数,它们会自动转换为数组
    void printVarargArray(int... x) {
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + ",");
        }
    }

    public static void main(String args[]) {
        VarargsEx o = new VarargsEx();

        //Using an array:
        int[] testArray = new int[]{10, 20};
        o.printVarargArray(testArray);

        System.out.println(" ");

        //Using a sequence of arguments
        o.printVarargArray(5, 6, 5, 8, 6, 31);
    }
}