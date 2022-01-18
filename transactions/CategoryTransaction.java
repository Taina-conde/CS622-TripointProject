package transactions;

import cards.BasicCard;
import cards.CreditCard;
import cards.PreferredCard;

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
        int pointsEarned = 0;
        if (card instanceof BasicCard) {
            switch(category) {
                case "travel":
                    pointValue = ((BasicCard)card).getTravelValue();
                    break;
                case "dining":
                    pointValue = ((BasicCard)card).getDiningValue();
                    break;
                case "onlineShop":
                    pointValue = ((BasicCard)card).getOnlineShopValue();
                    break;
                default:
                    pointValue = ((BasicCard)card).getGroceryValue();
                    break;
            }
        }
        if (card instanceof PreferredCard) {
            switch(category) {
                case "travel":
                    pointValue = ((PreferredCard)card).getTravelValue();
                    break;
                case "dining":
                    pointValue = ((PreferredCard)card).getDiningValue();
                    break;
                case "onlineShop":
                    pointValue = ((PreferredCard)card).getOnlineShopValue();
                    break;
                default:
                    pointValue = ((PreferredCard)card).getGroceryValue();
                    break;
            }
        }
        pointsEarned = (int)(amount * pointValue);
        card.addPoints(pointsEarned);
        return pointsEarned;
    }

}
