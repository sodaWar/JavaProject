package javaExample;

import java.io.IOException;

public class StringReverserThroughStack {
    // 利用压栈出栈的方法实现字符串反转
    private String input;
    private String output;
    public StringReverserThroughStack(String in) {
        input = in;
    }
    public String doRev() {
        int stackSize = input.length();                                                                                 // 定义输入的字符串内容长度
        Stack theStack = new Stack(stackSize);                                                                          // 创建Stack类的对象,传入长度参数,用于该类的构造函数使用
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);                                                                                  // 将字符串转换成字符数组
            theStack.push(ch);                                                                                          // 将字符数组中的每个字符存入到stackArray数组中
        }
        output = "";
        while (!theStack.isEmpty()) {
            char ch = theStack.pop();                                                                                   // 将字符从stackArray数组中取出,取出的方式跟pop函数有关系,采用后进先出的方式取出
            output = output + ch;
        }
        return output;
    }
    public static void main(String[] args) throws IOException {
        String input = "i love java and python";
        String output;
        StringReverserThroughStack theReverser = new StringReverserThroughStack(input);
        output = theReverser.doRev();
        System.out.println("反转前： " + input);
        System.out.println("反转后： " + output);
    }
    // 创建用于插入元素的自定义函数push()方法和用于弹出元素的pop()方法来实现栈后进先出的方式
    class Stack {
        private int maxSize;
        private char[] stackArray;
        private int top;
        public Stack(int max) {
            maxSize = max;
            stackArray = new char[maxSize];
            top = -1;
        }
        public void push(char j) {
            stackArray[++top] = j;
        }
        public char pop() {
            return stackArray[top--];
        }
        public char peek() {
            return stackArray[top];
        }
        public boolean isEmpty() {
            return (top == -1);
        }
    }
}