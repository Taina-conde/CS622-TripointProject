public class GroceryTransaction extends Transaction{
    private final String category = "grocery";
    public GroceryTransaction() {
        super();
    }
    public GroceryTransaction(CreditCard card,  double amount) {
        super(card, amount);
    }
    public String getCategory() {
        return category;
    }
    public int calculatePoints(){
        int pointValue= 0;
        int pointsEarned = 0;
        if (card instanceof BasicCard) {
            pointValue = ((BasicCard)card).getGroceryValue();
        }
        pointsEarned = (int)(amount * pointValue);
        card.addPoints(pointsEarned);
        return pointsEarned;
    }
}
