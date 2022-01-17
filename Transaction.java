public abstract class Transaction {
    protected double amount;
    protected CreditCard card;
    protected String category;

    public Transaction() {

    }
    public Transaction(CreditCard card, String category, double amount ) {
        this.amount = amount;
        this.card = card;
        this.category = category;
    }
    public abstract double getAmount();
    public abstract CreditCard getCard();
    public abstract String getCategory();

}
