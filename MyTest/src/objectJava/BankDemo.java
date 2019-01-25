package objectJava;

public class BankDemo {
    public static void main(String[] args){
        CheckingAccount c = new CheckingAccount(1226485112);
        System.out.println("Depositing 500-存500元....");
        c.deposit(500);
        try {
            System.out.println("Withdrawing 100-取100元....");
            c.withdraw(100);
            System.out.println("Withdrawing 600-取600元....");
            c.withdraw(600);
        }catch (InsufficientFundsException e){
            System.out.println("Sorry,your balance is short of " + e.getAmount());
//          异常的详细信息
            e.printStackTrace();
        }
    }
}
