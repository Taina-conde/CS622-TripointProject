public class BasicCard extends CreditCard{
    private final String type = "basic";
    private final int diningValue = 5;
    private final int groceryValue = 10;
    private final int onlineShopValue = 10;
    private final int travelValue = 5;
    public BasicCard() {
        super();
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
