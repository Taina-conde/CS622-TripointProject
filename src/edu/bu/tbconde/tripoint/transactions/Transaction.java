package edu.bu.tbconde.tripoint.transactions;

import edu.bu.tbconde.tripoint.cards.CreditCard;

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
    //getters
    public String getCategory() { return category;}
    public int getPoints() { return transPoints;}
    public double getAmount() {
        return amount;
    }
    public CreditCard getCard() {return card;}
    // calculate points earned in this transaction
    public abstract int calculatePoints();
}
