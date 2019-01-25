package highJava;

public class GenericityTest2<T> {
    private T t;

    public void add(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public static void main(String[] args) {
        GenericityTest2<Integer> ig = new GenericityTest2<Integer>();
        GenericityTest2<String> sg = new GenericityTest2<String>();

        ig.add(new Integer(10));
        sg.add(new String("我爱编程"));

        System.out.printf("整型值为 :%d\n\n", ig.get());
        System.out.printf("字符串为 :%s\n", sg.get());
    }
}
