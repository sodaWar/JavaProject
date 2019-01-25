package objectJava;

public class CheckingAccount {
//  balance是余额,number是卡号
    private double balance;
    private int number;
    public CheckingAccount(int number){
        this.number = number;
    }
//  存钱
    public void deposit(double amount){
        balance += amount;
    }
//  取钱
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= balance){
            balance -= amount;
        }
        else {
            double lack = amount - balance;
            throw new InsufficientFundsException(lack);
        }
    }
//  返回余额
    public double getBalance() {
        return balance;
    }
// 返回卡号
    public int getNumber() {
        return number;
    }
}
