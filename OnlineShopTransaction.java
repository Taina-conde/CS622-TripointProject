public class OnlineShopTransaction extends Transaction{
    private final String category = "onlineShop";
    public OnlineShopTransaction() {
        super();
    }
    public OnlineShopTransaction(CreditCard card,  double amount) {
        super(card, amount);
    }
    public String getCategory() {
        return category;
    }
    public int calculatePoints(){
        int pointValue= 0;
        int pointsEarned = 0;
        if (card instanceof BasicCard) {
            pointValue = ((BasicCard)card).getOnlineShopValue();
        }
        pointsEarned = (int)(amount * pointValue);
        card.addPoints(pointsEarned);
        return pointsEarned;
    }
}
