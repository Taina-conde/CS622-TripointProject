package edu.bu.tbconde.tripoint.transactions;

import edu.bu.tbconde.tripoint.cards.CreditCard;

public class CategoryTransaction extends Transaction {
    public CategoryTransaction() {
        super();
    }
    public CategoryTransaction(CreditCard card, String category, double amount) {
        super(card, category, amount);
    }
    public String getCategory() {
        return category;
    }

    @Override
    public int calculatePoints(){
        int pointValue;
        pointValue = card.getCategoryValue(category);
        this.transPoints = (int)(amount * pointValue);
        return this.transPoints;
    }

}
