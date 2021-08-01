
class Withdraw extends Thread {
    private BankAccount acount;

    public Withdraw(BankAccount acc) {
        super(" Withdraw from account: \n");
        acount = acc;
    }
    public void run() {
        boolean temp = true;
        do {
            try {
                Thread.sleep( (int) ( Math.random() * 3000 ) );
            } catch(InterruptedException e) {
                System.err.println(e.toString());
            }
            temp = acount.withdraw();
        } while (true);

    }
}
