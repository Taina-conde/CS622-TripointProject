package transactions;

import cards.BasicCard;
import cards.CreditCard;
import cards.PreferredCard;
import util.RecordsWriter;

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
