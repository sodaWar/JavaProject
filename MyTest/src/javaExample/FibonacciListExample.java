package javaExample;

public class FibonacciListExample {
    // 斐波那契数列,这个数列从第三项开始,每一项都等于前两项之和
    public static long fibonacci(long number) {
        if ((number == 0) || (number == 1))
            return number;
        else
            return fibonacci(number - 1) + fibonacci(number - 2);
    }
    // 阶乘
    public static long factorial(long number) {
        if (number <= 1)
            return 1;
        else
            return number * factorial(number - 1);
    }
    public static void main(String[] args) {
        for (int counter = 0; counter <= 10; counter++){
            System.out.printf("Fibonacci of %d is: %d\n",
                    counter, factorial(counter));
        }
    }
}