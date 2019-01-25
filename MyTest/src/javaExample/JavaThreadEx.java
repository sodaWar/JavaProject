package javaExample;

public class JavaThreadEx extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            printMsg();
        }
    }

    public void printMsg() {
        Thread t = Thread.currentThread();
        String name = t.getName();
        System.out.println("name=" + name);
    }

    public static void main(String[] args){
        // 使用getName()方法来获取当前线程名称,线程对象调用start()方法后会自动执行run()方法
        JavaThreadEx tt = new JavaThreadEx();
        tt.start();
        for (int i = 0; i < 10; i++) {
            tt.printMsg();
        }
        // 使用isAlive()方法来检测一个线程是否存活
        JavaThreadEx ss = new JavaThreadEx();
        tt.setName("Thread");
        System.out.println("before start(), tt.isAlive()=" + ss.isAlive());
        tt.start();
        System.out.println("just after start(), tt.isAlive()=" + ss.isAlive());
        for (int i = 0; i < 10; i++) {
            ss.printMsg();
        }
        System.out.println("The end of main(), tt.isAlive()=" + ss.isAlive());

    }
}

