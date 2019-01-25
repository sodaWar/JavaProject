package javaExample;
import java.util.LinkedList;                                                                                            // 链表的jar包
import java.util.Collections;
import java.util.Vector;
import java.util.Queue;

public class JavaDataStructureEx {
    public static void main(String[] args){
        /*
        // 使用LinkedList类的addFirst()和addLast()方法在链表的开头和结尾添加元素,使用getFirst()和getLast()来获取链表的第一个和最后一个元素
        LinkedList<String> lList = new LinkedList<String>();
        lList.add("1");
        lList.add("2");
        lList.add("3");
        System.out.println(lList);
        lList.addFirst("0");
        System.out.println(lList);
        lList.addLast("4");
        lList.addLast("4");
        System.out.println(lList);
        // indexof()可在链表中获取元素第一次的出现的位置,Lastindexof()是最后一次出现的位置
        System.out.println("元素4第一次出现的位置：" + lList.indexOf("4"));
        System.out.println("元素4最后一次出现的位置："+ lList.lastIndexOf("4"));
        System.out.println("链表的第一个元素是：" + lList.getFirst());
        System.out.println("链表的最后一个元素是：" + lList.getLast());
        lList.set(2, "M");                                                                                              // 使用set()方法来修改链接中的元素,第一个参数是索引位置,第二个是修改的值
        System.out.println(officers);
        // subList()方法作用是返回一个以fromIndex为起始索引（包含）,以toIndex为终止索引（不包含）的子列表（List）,clear()方法用来删除链表中的元素
        lList.subList(1, 2).clear();
        System.out.println(lList);
        // 这里removeFirst()是删除链表中的第一个元素,并返回删除的元素值
        System.out.println(lList.pop());
        System.out.println(lList.pop());
        */
        structure2();

    }

    public Object pop(LinkedList list) {
        return list.removeFirst();
    }

    public static void structure(){
        // Vector是向量类,可实现自动增长的对象数组,类似动态数组的功能,创建一个向量类对象后,可以往其中随意插入不同类的对象,不需顾及类型也不需预先选定向量的容量,并可以方便地进行查找
        // 对于预先不知或者不愿预先定义数组大小,并且需要频繁地进行查找,插入,删除工作的情况,可以考虑使用向量类
        Vector v = new Vector();
        v.add("X");
        v.add("M");
        v.add("D");
        v.add("A");
        v.add("O");
        Collections.sort(v);                                                                                            // Collections类的sort()方法对向量进行排序
        System.out.println(v);
        int index = Collections.binarySearch(v, "D");                                                              // 使用binarySearch()方法来获取向量元素的索引值
        System.out.println("元素索引值为 : " + index);
        // 使用Collections.swap()函数来旋转向量,这里旋转是指以中间为分界线,两边互换位置
        Collections.swap(v, 0, 4);
        System.out.println("旋转后");
        System.out.println(v);
        Object obj = Collections.max(v);                                                                                //  使用Collections.max()来获取向量的最大元素
        System.out.println("最大元素是："+obj);
    }

    public static void structure2(){
        // 队列是一种特殊的线性表,它只允许在表的前端进行删除操作,而在表的后端进行插入操作,LinkedList类实现了Queue接口,因此我们可以把LinkedList当成Queue来用
        // add()和remove()方法在失败的时候会抛出异常(不推荐)
        Queue<String> queue = new LinkedList<String>();
        //添加元素
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        for(String q : queue){
            System.out.println(q);
        }
        System.out.println("==========");
        System.out.println("poll="+queue.poll());                                                                       //返回第一个元素，并在队列中删除
        System.out.println("==========");
        System.out.println("element="+queue.element());                                                                 //返回第一个元素
        System.out.println("==========");
        System.out.println("peek="+queue.peek());                                                                       //返回第一个元素
    }

}
