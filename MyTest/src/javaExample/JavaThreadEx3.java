package javaExample;

public class JavaThreadEx3 extends Object implements Runnable {
    private ThreadID var;

    public JavaThreadEx3(ThreadID v) {
        this.var = v;
    }

    public void run() {
        try {
            print("var getThreadID =" + var.getThreadID());
            Thread.sleep(2000);
            print("var getThreadID =" + var.getThreadID());
        } catch (InterruptedException x) {
        }
    }

    private static void print(String msg) {
        String name = Thread.currentThread().getName();
        System.out.println(name + ": " + msg);
    }

    public static void main(String[] args) {
        ThreadID tid = new ThreadID();
        JavaThreadEx3 shared = new JavaThreadEx3(tid);

        try {
            Thread threadA = new Thread(shared, "threadA");
            threadA.start();

            Thread.sleep(500);

            Thread threadB = new Thread(shared, "threadB");
            threadB.start();

            Thread.sleep(500);

            Thread threadC = new Thread(shared, "threadC");
            threadC.start();
        } catch (InterruptedException x) {
        }
    }
}
// ThreadLocal是一个关于创建线程局部变量的类,通常情况下,我们创建的变量是可以被任何一个线程访问并修改的,而使用ThreadLocal创建的变量只能被当前线程访问,其他线程则无法访问和修改
class ThreadID extends ThreadLocal {
    private int nextID;

    public ThreadID() {
        nextID = 10001;
    }
// 一个线程访问一个对象中的synchronized(this)同步代码块时,其他试图访问该对象的线程将被阻塞;当一个线程访问对象的一个synchronized(this)同步代码块时,另一个线程仍然可以访问该对象中的非synchronized(this)同步代码块
    private synchronized Integer getNewID() {
        Integer id = new Integer(nextID);
        nextID++;
        return id;
    }


    protected Object initialValue() {
        print("in initialValue()");
        return getNewID();
    }

    public int getThreadID() {
        Integer id = (Integer) get();
        return id.intValue();
    }

    private static void print(String msg) {
        String name = Thread.currentThread().getName();
        System.out.println(name + ": " + msg);
    }
}