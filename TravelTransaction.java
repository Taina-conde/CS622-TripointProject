public class TravelTransaction extends Transaction {
    private final String category = "travel";
    public TravelTransaction() {
        super();
    }
    public TravelTransaction(CreditCard card,  double amount) {
        super(card, amount);
    }
    public String getCategory() {
        return category;
    }
    public int calculatePoints(){
        int pointValue= 0;
        int pointsEarned = 0;
        if (card instanceof BasicCard) {
            pointValue = ((BasicCard)card).getTravelValue();
        }
        if (card instanceof PreferredCard) {
            pointValue = ((PreferredCard)card).getTravelValue();
        }
        pointsEarned = (int)(amount * pointValue);
        card.addPoints(pointsEarned);
        return pointsEarned;
    }

}
