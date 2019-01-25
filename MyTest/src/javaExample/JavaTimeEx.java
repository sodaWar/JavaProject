package javaExample;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JavaTimeEx {
    public static void main(String[] args){
        /*
        // 使用SimpleDateFormat类的format(date)方法来格式化时间
        Date date = new Date();
        String strDateFormat = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        System.out.println(sdf.format(date));

        // Calendar类是一个抽象类,这里Calendar.getInstance()是获取当前时间,在处理日期和时间时,系统推荐使用Calendar类进行实现,这里不同的是获得的月份为实际的月份值减1,所以需要加1
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DATE);
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        int dow = cal.get(Calendar.DAY_OF_WEEK);
        int dom = cal.get(Calendar.DAY_OF_MONTH);
        int doy = cal.get(Calendar.DAY_OF_YEAR);
        // 使用Calendar可以获得日期的月份、天数等
        System.out.println("当期时间: " + cal.getTime());
        System.out.println("日期: " + day);
        System.out.println("月份: " + month);
        System.out.println("年份: " + year);
        System.out.println("一周的第几天: " + dow);  // 星期日为一周的第一天输出为 1,星期一输出为 2,以此类推
        System.out.println("一月中的第几天: " + dom);
        System.out.println("一年的第几天: " + doy);
                */
        // 使用SimpleDateFormat类的format()方法将时间戳转换成时间
        Long timeStamp = System.currentTimeMillis();                                    //获取当前时间戳
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 先将时间戳格式的timeStamp利用String.valueOf()方法转换为字符串格式;Long.ParseLong(String)方法,作用是将string参数解析为有符号十进制 ,返回一个long的result基本类型值
        long s1 = Long.parseLong(String.valueOf(timeStamp));
        Date date = new Date();
        System.out.println(date);
        System.out.println(new Date(s1));           // 这里是验证s1只是和date的类型不一样,s1是有符号的十进制,date是实际时间格式,分别是Fri Jan 11 16:52:46 CST 2019和1547196766736形式
        String sd = sdf.format(new Date(s1));      // 时间戳转换成时间,这里format()方法参数是Date类型的数据,所以需要将s1赋值到new Date中
        System.out.println("格式化结果：" + sd);

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        String sd2 = sdf2.format(new Date(Long.parseLong(String.valueOf(timeStamp))));
        System.out.println("格式化结果：" + sd2);

        // 以下3种方式都可以转换时间
        String sd3 = sdf.format(Long.parseLong(String.valueOf(timeStamp)));
        String sd4 = sdf.format(new Date(Long.parseLong(String.valueOf(timeStamp))));
        String sd5 = sdf.format(timeStamp);
    }
}
