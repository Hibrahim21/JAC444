
class Adder extends Thread {
    private BankAccount acount;
    private Money[] money;

    public Adder(BankAccount c, Money[] n) {
        super(" Deposit to account: \n");
        acount = c;
        money = n;
    }

    public void run() {

        for (int count = 0; count < money.length; count++) {

            try {
                Thread.sleep( (int) ( Math.random() * 3000 ) );
            } catch(InterruptedException e) {
                System.err.println(e.toString());
            }
                int temp = money[count].getAmount();
                for (int i =0 ; i<temp ; i++){
                    acount.Deposite(money[count]);
                }
        }
    }
}
