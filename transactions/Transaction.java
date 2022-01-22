package transactions;

import cards.CreditCard;

public abstract class Transaction {
    protected double amount;
    protected String cardType;
    protected CreditCard card;
    protected String category;
    protected int transPoints;
    public Transaction() {
    }
    public Transaction(CreditCard card, String category, double amount ) {
        this.amount = amount;
        this.category = category;
        this.card = card;
    }

    protected int getTransPoints() { return transPoints;}
    protected void setTransPoints(int transPoints) { this.transPoints = transPoints; }
    public CreditCard getCard() {return card;}
    // calculate points earned in this transaction
    public abstract int calculatePoints();

    //display transaction to the console
    public abstract void displayTransaction();
    //save transaction to transactionsRecord
    public abstract void saveTransaction();
}
