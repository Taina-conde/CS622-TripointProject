public abstract class Transaction {
    protected double amount;
    protected String cardType;
    protected String category;

    public Transaction() {

    }
    public Transaction(String cardType, String category, double amount ) {
        this.amount = amount;
        this.cardType = cardType;
        this.category = category;
    }

}
