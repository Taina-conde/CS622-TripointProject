public abstract class Transaction {
    protected double amount;
    protected CreditCard card;


    public Transaction() {

    }
    public Transaction(CreditCard card, double amount ) {
        this.amount = amount;
        this.card = card;

    }
    //getters
    public double getAmount() {
        return amount;
    }
    public  CreditCard getCard() {
        return card;
    }

    //setters
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public void setCard(CreditCard card) {
        this.card = card;
    }
    
    // calculate points earned in this transaction
    public abstract int calculatePoints();


}
