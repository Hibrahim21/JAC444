//import java.lang.*;

public class Account {
    public static void main(String[] args) {
        BankAccount BankAccount = new BankAccount();
        Money[] money = { 	 new Money(1,'D'),new Money(2,'E'),new Money(3,'P')		};
        Adder Hamza = new Adder(BankAccount, money);
        Withdraw Friend = new Withdraw(BankAccount);
        Hamza.start();
        Friend.start();

        try{
            Hamza.join();
            Friend.join();
        }catch (InterruptedException e){
        }

    }
}
