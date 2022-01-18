public class PreferredCard extends CreditCard {
    private final String type = "preferred";
    private final int diningValue = 10;
    private final int groceryValue = 5;
    private final int onlineShopValue = 5;
    private final int travelValue = 10;
    public PreferredCard() {
        super();
    }
    public PreferredCard(String customer) {
        super(customer);
    }
    public PreferredCard(String customer, int pointsBal) {
        super(customer, pointsBal);
    }
    public int getDiningValue() {
        return diningValue;
    }
    public int getGroceryValue() {
        return groceryValue;
    }
    public int getOnlineShopValue() {
        return onlineShopValue;
    }
    public int getTravelValue() {
        return travelValue;
    }
}
