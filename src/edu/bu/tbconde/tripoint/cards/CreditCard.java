package edu.bu.tbconde.tripoint.cards;

public abstract class CreditCard {
    protected String customer;
    protected static int pointsBal;

    public CreditCard( String customer, int pointsBal) {
        this.customer = customer;
        this.pointsBal += pointsBal;
    }
    public CreditCard( String customer) {this( customer, 0);}
    public CreditCard() {
        this("");
    }
    public abstract String getType();
    public abstract int getCategoryValue(String category);

}
