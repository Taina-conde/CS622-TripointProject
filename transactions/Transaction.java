package transactions;

import cards.CreditCard;

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
    // calculate points earned in this transaction
    public abstract int calculatePoints();

    //display transaction to the console
    public abstract void displayTransaction();
}
