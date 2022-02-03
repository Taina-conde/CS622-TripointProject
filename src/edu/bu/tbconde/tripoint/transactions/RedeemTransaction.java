package edu.bu.tbconde.tripoint.transactions;

public class RedeemTransaction extends Transaction {
    public RedeemTransaction() {
        super();
    }
    public int calculatePoints(){
        //to redeem: for every $1 dollar, he/she has to spend 2 points.
        int points = 2 * (int)this.amount;
        return points;
    }
}