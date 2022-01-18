public class DiningTransaction extends Transaction {
    private final String category = "dining";
    public DiningTransaction() {
        super();
    }
    public DiningTransaction(CreditCard card,  double amount) {
        super(card, amount);
    }
    public String getCategory() {
        return category;
    }
    public int calculatePoints(){
        int pointValue= 0;
        int pointsEarned = 0;
        if (card instanceof BasicCard) {
            pointValue = ((BasicCard)card).getDiningValue();
        }
        pointsEarned = (int)(amount * pointValue);
        card.addPoints(pointsEarned);
        return pointsEarned;
    }
}
