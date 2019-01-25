package objectJava;

public class InsufficientFundsException extends Exception{
    private double amount;
//  该异常类的构造方法,用于初始化,这里是用来在调用该异常类时初始化amount值,该amount值是取钱时所取钱-余额的值,即取钱所缺少的钱
    public InsufficientFundsException(double amount){
        this.amount = amount;
    }
//  获得amount值
    public double getAmount() {
        return amount;
    }
}
