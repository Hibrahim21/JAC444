
class Money{
    int amount;
    char currency;

    public Money(int amount,char cur) {
        this.amount = amount;
        this.currency = cur;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public char getCurrency() {
        return currency;
    }

    public void setCurrency(char currency) {
        this.currency = currency;
    }
}
