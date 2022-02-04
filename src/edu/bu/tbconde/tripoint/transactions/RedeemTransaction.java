package edu.bu.tbconde.tripoint.transactions;

public class RedeemTransaction extends Transaction {
    public RedeemTransaction( double amount) {
        super(amount);
        type = "redeem";
        //to redeem: for every $1 dollar, he/she has to spend 2 points.
        catValue = 2;
        calculatePoints();
    }
    public int calculatePoints(){
        points = (int)(amount * catValue);
        return points;
    }
    @Override
    public String toString() {
        return category + ", " + amount;
    }
}
