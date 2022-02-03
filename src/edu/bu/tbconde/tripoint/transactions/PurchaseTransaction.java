package edu.bu.tbconde.tripoint.transactions;

import edu.bu.tbconde.tripoint.cards.CreditCard;

public class PurchaseTransaction extends Transaction {
    public PurchaseTransaction() {
        super();
    }
    public PurchaseTransaction(CreditCard card, String category, double amount) {
        super(card, category, amount);
    }
    public String getCategory() {
        return category;
    }

    @Override
    public int calculatePoints(){
        int pointValue;
        pointValue = card.getCategoryValue(category);
        this.points = (int)(amount * pointValue);
        return this.points;
    }

}
