package edu.bu.tbconde.tripoint.transactions;

import edu.bu.tbconde.tripoint.cards.CreditCard;

import java.io.Serializable;

public abstract class Transaction implements Serializable {
    protected double amount = 0;
    protected String cardType = null;
    protected CreditCard card = null;
    protected String category = null;
    protected int points = 0;
    public Transaction() {
    }
    public Transaction(CreditCard card, String category, double amount ) {
        this.amount = amount;
        this.category = category;
        this.card = card;
    }
    public Transaction( String category, double amount ) {
        this.amount = amount;
        this.category = category;
    }

    protected void setPoints(int points) { this.points = points; }
    //getters
    public String getCategory() { return category;}
    public int getPoints() { return points;}
    public double getAmount() {
        return amount;
    }
    public CreditCard getCard() {return card;}
    // calculate points earned in this transaction
    public abstract int calculatePoints();
}
