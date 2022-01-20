package transactions;

import cards.BasicCard;
import cards.CreditCard;
import cards.PreferredCard;
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

    public void displayTransaction() {
        System.out.println(
                "You spent $" + amount + " on " + category + " using your " + card.getType() + " card.\n" +
                "The " + card.getType() + " card gives you "+ card.getCategoryValue(category) +
                        " points for every $1 spent on " +  category + ". \n" +
                "You earned " + calculatePoints() + " points in this transaction. \n");
    }

    public void saveTransaction() {
        String trans = card.getType() + ", " + category + ", " + amount + ", " + calculatePoints();
        System.out.println("trans string " + trans );
        try {
            FileWriter fr = new FileWriter("io/transactionsRecord.txt");
            BufferedWriter br = new BufferedWriter(fr);
            br.write(trans);
            br.close();

        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
