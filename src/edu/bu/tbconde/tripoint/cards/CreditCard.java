package edu.bu.tbconde.tripoint.cards;

public abstract class CreditCard {
    protected String customer;
    protected static int pointsBal;
    protected String type;

    public CreditCard(String type, String customer, int pointsBal) {
        this.type = type;
        this.customer = customer;
        this.pointsBal += pointsBal;
    }
    public CreditCard(String type, String customer) {this(type, customer, 0);}
    public CreditCard(String type) {this(type, "");}
    public CreditCard() {
        this("");
    }

    public String getType() {
        return type;
    }

    public abstract int getCategoryValue(String category);

}
