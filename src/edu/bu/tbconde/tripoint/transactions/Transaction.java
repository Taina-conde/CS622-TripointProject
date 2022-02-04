package edu.bu.tbconde.tripoint.transactions;

import edu.bu.tbconde.tripoint.cards.CreditCard;

import java.io.Serializable;

public abstract class Transaction implements Serializable {
    protected String type;
    protected double amount = 0;
    protected String cardType = null;
    protected CreditCard card = null;
    protected String category = null;
    protected int catValue = 0;
    protected int points = 0;
    public Transaction() {
    }
    public Transaction(CreditCard card, String category, double amount ) {
        this.amount = amount;
        this.category = category;
        this.card = card;
        this.cardType = card.getType();
        this.catValue = card.getCategoryValue(this.category);
    }
    public Transaction( double amount ) {
        this.amount = amount;
        cardType = "NA";
        category ="NA";
    }

    protected void setPoints(int points) { this.points = points; }
    //getters
    public String getType() {return type;}
    public String getCardType() { return cardType;}
    public String getCategory() { return category;}
    public int getCatValue() {return catValue;}
    public int getPoints() { return points;}
    public double getAmount() {
        return amount;
    }
    public CreditCard getCard() {return card;}
    // calculate points earned in this transaction
    public abstract int calculatePoints();

}
