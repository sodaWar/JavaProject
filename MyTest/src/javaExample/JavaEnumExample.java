package javaExample;
// 枚举类型的常见用法有时间学习！！
// 创建枚举类型要使用enum关键字,隐含了所创建的类型都是java.lang.Enum类的子类,以下是对enum进行遍历和switch操作的示例
enum Car {
    lamborghini,tata,audi,fiat,honda
}
// 枚举构造函数及方法的使用,特别注意这个枚举函数的使用！！！枚举类中的枚举值都会对应调用一次构造函数,也就是说有5个枚举值,在创建该类的对象时,会调用5次构造函数,枚举值默认static,会为每个类常量增加一个构造函数
enum Car2 {
    lamborghini(900),tata(2),audi(50),fiat(15),honda(12);
    private int price;
    Car2(int p) {
        price = p;
    }
    int getPrice() {
        return price;
    }
}

public class JavaEnumExample {
    public static void main(String args[]){
        /*
        Car c;
        c = Car.tata;
        switch(c) {
            case lamborghini:
                System.out.println("你选择了 lamborghini!");
                break;
            case tata:
                System.out.println("你选择了 tata!");
                break;
            case audi:
                System.out.println("你选择了 audi!");
                break;
            case fiat:
                System.out.println("你选择了 fiat!");
                break;
            case honda:
                System.out.println("你选择了 honda!");
                break;
            default:
                System.out.println("我不知道你的车型。");
                break;
        }
        */
        System.out.println("所有汽车的价格:");
        for (Car2 c : Car2.values())
            System.out.println(c + "需要 "
                    + c.getPrice() + "千美元");
    }
}
