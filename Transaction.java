public abstract class Transaction {
    protected double amount;
    protected String cardType;


    public Transaction() {

    }
    public Transaction(String cardType, double amount ) {
        this.amount = amount;
        this.cardType = cardType;

    }
    //getters
    public double getAmount() {
        return amount;
    }
    public  String getCardType() {
        return cardType;
    }

    //setters
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public void setCard(String cardType) {
        this.cardType = cardType;
    }
    
    // calculate points earned in this transaction
    public abstract int calculatePoints();


}
