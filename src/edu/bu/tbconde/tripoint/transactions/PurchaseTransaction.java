package edu.bu.tbconde.tripoint.transactions;

import edu.bu.tbconde.tripoint.cards.CreditCard;

public class PurchaseTransaction extends Transaction {
    public PurchaseTransaction(CreditCard card, String category, double amount) {
        super(card, category, amount);
        type = "purchase";
    }
    public String getCategory() {
        return category;
    }

    @Override
    public int calculatePoints(){
        this.points = (int)(amount * catValue);
        return this.points;
    }
    @Override
    public String toString() {
        return cardType + ", " + category + ", " + amount;
    }
}
