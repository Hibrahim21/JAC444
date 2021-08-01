
class BankAccount {
    private int balance = 0;
    private char Currency ;

	public synchronized void Deposite(Money money) {

            while ((balance != 0) && (money.getCurrency() != Currency)) {  
                try {
                    System.out.println("Waiting for withdraw...");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            balance += 1;
            System.err.println(Thread.currentThread().getName()+" " +
                    " Deposit added " + 1 + " " + money.getCurrency() + " and balance = " + balance);

            Currency = money.getCurrency();
            notify();
 
    }
    public synchronized boolean withdraw() {
        while (balance == 0) {
            try{
                System.out.println("Waiting for Deposit...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        balance -= 1;
        System.err.println( Thread.currentThread().getName() +
                " withdraw 1 " + Currency + " and balance = " + balance) ;
        notify();
        boolean temp = true;
        if (balance == 0){
            temp = false;
        }
        return temp;
    }
}