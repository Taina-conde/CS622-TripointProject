package cards;

public class BasicCard extends CreditCard {
    public BasicCard() {
        super();
    }
    public BasicCard(String customer) {
        super(customer);
    }
    public BasicCard(String customer, int pointsBal) {
        super(customer, pointsBal);
    }
    public int getCategoryValue(String category) {
        switch(category) {
            case "travel":
                return 5;
            case "dining":
                return 3;
            case "onlineShop":
                return 10;
            default:
                return 8;
        }
    }
}
