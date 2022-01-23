package edu.bu.tbconde.myproject.transactions;

import edu.bu.tbconde.myproject.cards.BasicCard;
import edu.bu.tbconde.myproject.cards.CreditCard;
import edu.bu.tbconde.myproject.cards.PreferredCard;
import edu.bu.tbconde.myproject.util.RecordsWriter;

import java.io.*;

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

    public int calculatePoints(){
        int pointValue= 0;
        if (card instanceof BasicCard) {

            pointValue = ((BasicCard)card).getCategoryValue(category);

        }
        if (card instanceof PreferredCard) {

            pointValue = ((PreferredCard)card).getCategoryValue(category);
        }
        this.transPoints = (int)(amount * pointValue);
        return this.transPoints;
    }

}
