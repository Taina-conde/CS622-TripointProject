package edu.bu.tbconde.tripoint.transactions;

public class RedeemTransaction extends Transaction {
    public RedeemTransaction() {
        super();
    }
    public int calculatePoints(){
        return -(int)this.amount;
    }
}
