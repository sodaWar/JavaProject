package javaExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.lang3.ArrayUtils;

public class JavaArrayEx {
    public static void main(String[] args){
        /*
        // 使用Arrays类中的sort()方法对数组进行排序,以及使用binarySearch()方法来查找数组中的元素, printArray()方法是定义用来打印数组
        int array[] = { 2, 5, -2, 6, -3, 8, 0, -7, -9, 4 };
        Arrays.sort(array);
        printArray("数组排序结果为", array);
        int index = Arrays.binarySearch(array, 2);
        System.out.println("元素 2  在第 " + index + " 个位置");

        // 使用Collections.reverse(ArrayList)将数组进行反转
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");
        arrayList.add("E");
        System.out.println("反转前排序: " + arrayList);
        Collections.reverse(arrayList);
        System.out.println("反转后排序: " + arrayList);

        // Arrays.asList()方法是将一个数组转化为一个List对象,该方法返回一个ArrayList类型的对象,但是该类不是java.util.ArrayList类,而是Arrays类的静态内部类！用这个对象对列表进行增加删除更新操作,会报异常
        Integer[] numbers = { 8, 2, 7, 1, 4, 9, 5};
        int min = (int) Collections.min(Arrays.asList(numbers));
        int max = (int) Collections.max(Arrays.asList(numbers));
        System.out.println("最小值: " + min);
        System.out.println("最大值: " + max);

        // 通过List类的Arrays.toString()方法和List类的list.Addall(array1.asList(array2)方法将两个数组合并为一个数组,toArray()是将list转换为Object[]数组
        String a[] = { "A", "E", "I" };
        String b[] = { "O", "U" };
        List list = new ArrayList(Arrays.asList(a));
        list.addAll(Arrays.asList(b));
        Object[] c = list.toArray();
        System.out.println(Arrays.toString(c));

        // 通过Java Util类的Arrays.fill()方法向数组中填充元素,如果填充的位置没有元素则填充新元素,如果有元素则用新元素替代旧元素.
        // 该方法有两种参数形式：Arrays.fill(arrayname,value) 方法和Arrays.fill(arrayname ,starting index ,ending index ,value) ,第一种是所有数组中元素都填充为value值,第二种是数组区间内的元素都填充为value值
        int array[] = new int[6];
        Arrays.fill(array, 100);
        for (int i=0, n=array.length; i < n; i++) {
            System.out.println(array[i]);
        }
        System.out.println();
        Arrays.fill(array, 3, 6, 50);
        for (int i=0, n=array.length; i< n; i++) {
            System.out.println(array[i]);
        }

        // 如何在数组初始化后对数组进行扩容,可使用System.arraycopy()实现数组之间的复制.System提供的静态方法arraycopy(),可用来实现数组之间的复制,函数原型是public static void (Object src,int srcPos,Object dest,int destPos,int length)
        // src:源数组;srcPos:源数组要复制的起始位置;dest:目的数组;destPos:目的数组放置的起始位置;length:复制的长度.注意,src and dest都必须是同类型或者可以进行转换类型的数组,该函数可以自己复制自己
        String[] names = new String[] { "A", "B", "C" };
        String[] extended = new String[5];
        extended[3] = "D";
        extended[4] = "E";
        System.arraycopy(names, 0, extended, 0, names.length);
        for (String str : extended){
            System.out.println(str);
        }

        // 通过循环数组,并与剩余数组内的值比较,相同就显示该元素
        int[] my_array = {1, 2, 5, 5, 6, 6, 7, 2, 9, 2};
        findDupicateInArray(my_array);

        // ArrayList类中的remove()方法有两种类型的参数,第一种是数组的下标值index,第二种是数组的元素值element
        ArrayList<String> objArray = new ArrayList<String>();
        objArray.clear();
        objArray.add(0,"第 0 个元素");
        objArray.add(1,"第 1 个元素");
        objArray.add(2,"第 2 个元素");
        System.out.println("数组删除元素前："+objArray);
        objArray.remove(1);
        objArray.remove("第 0 个元素");
        System.out.println("数组删除元素后："+objArray);

        // 使用removeAll()方法来计算两个数组的差集,该结果输出notcommon2,该方法原理是将array1所有的元素在array2中删除,如果删除不了就是两个数组的差集了,可以通过最后输出array1的值看出,array1值只有notcommon2,其他值都被删除了
        // 使用retainAll()方法可以计算两个数组的交集,使用contains()方法查找数组中的指定元素,如objArray.contains("common2"),objArray数组中包含common2所以返回结果是true,如果不包含返回false
        // 判断两个数组是否相等使用equals()方法,使用方式如Arrays.equals(ary1, ary2)
        ArrayList objArray = new ArrayList();
        ArrayList objArray2 = new ArrayList();
        objArray2.add(0,"common1");
        objArray2.add(1,"common2");
        objArray2.add(2,"notcommon");
        objArray2.add(3,"notcommon1");
        objArray.add(0,"common1");
        objArray.add(1,"common2");
        objArray.add(2,"notcommon2");
        System.out.println("array1 的元素" +objArray);
        System.out.println("array2 的元素" +objArray2);
        objArray.removeAll(objArray2);
        System.out.println("array1 与 array2 数组差集为："+objArray);

        // 这里使用的是ArrayUtils类的addAll()方法,该类需要导入commons.lang3.ArrayUtils.jar包才能使用,其中包含的方法有添加add,addAll、删除remove,removeAll,拷贝clone,反转reverse,截取subarray
        // 查找indexOf、contains,转换toArray、toMap、toString等,具体需要操作数组时用到该类的方法,再实际查看用法
        String[] str1 = new String[] {"A","B","C"};
        String[] str2 = new String[] {"D","E"};
        String[] both = ArrayUtils.addAll(str1, str2);
        for (String i:both) {
            System.out.print(i);
        }
        */

        String[] arr1 = { "1", "2", "3" };
        String[] arr2 = { "4", "5", "6" };
        String[] result_union = union(arr1, arr2);
        System.out.println("并集的结果如下：");

        for (String str : result_union) {
            System.out.println(str);
        }

    }
    private static void printArray(String message, int array[]) {
        System.out.println(message
                + ": [length: " + array.length + "]");
        for (int i = 0; i < array.length; i++) {
            if(i != 0){
                System.out.print(", ");
            }
            System.out.print(array[i]);
        }
        System.out.println();
    }

    private static void findDupicateInArray(int[] a) {
        int count=0;
        for(int j=0;j<a.length;j++) {
            for(int k =j+1;k<a.length;k++) {
                if(a[j]==a[k]) {
                    count++;
                }
            }
            if(count==1)
                System.out.println( "重复元素 : " +  a[j] );
            count = 0;
        }
    }

    // 求两个字符串数组的并集,利用set的元素唯一性
    public static String[] union(String[] arr1, String[] arr2) {
        Set<String> set = new HashSet<String>();

        for (String str : arr1) {
            set.add(str);
        }

        for (String str : arr2) {
            set.add(str);
        }

        String[] result = {  };
        /* 对于Set而言,它只知道它内部保存的是Object,所以默认情况下,toArray只能是返回一个由这些Object构成的Object数组出来;
         但程序的作者更清楚其内部元素的更具体的类型,因此,HashSet类提供了toArray的另一个重载版本,允许用户指定一种比Object[]更具体的数组类型,方法是传递一个用户想要的数组类型的一个数组实例进去,多长都无所谓
         所以这里result的作用只是传递一个String数组类型到set中,然后toArray内部就会按照你想要的这种类型,给构造一个数组出来,这样构造出来的数组就被转换为实际需要的类型了
         这里注意,如果使用String[] strs = (String[]) set.toArray();来讲set转换为String数组类型,会报错;原因是String是一种类型,String[]是另一种类型,Object可以强转为String,不代表Object[]类型可以强转为String[]类型
         */
        return set.toArray(result);
    }

}
