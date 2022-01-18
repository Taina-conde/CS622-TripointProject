public abstract class Transaction {
    protected double amount;
    protected String cardType;
    protected CreditCard card;
    protected String category;


    public Transaction() {

    }
    public Transaction(CreditCard card, String category, double amount ) {
        this.amount = amount;
        this.category = category;
        this.card = card;

    }
    //getters
    public double getAmount() {
        return amount;
    }
    public  String getCardType() {
        return cardType;
    }
    public CreditCard getCard() {
        return card;
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
