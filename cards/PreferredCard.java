package cards;

public class PreferredCard extends CreditCard {
    public PreferredCard() {
        super();
    }
    public PreferredCard(String customer) {
        super(customer);
    }
    public PreferredCard(String customer, int pointsBal) {
        super(customer, pointsBal);
    }

    public int getCategoryValue(String category) {
        switch (category) {
            case "travel":
                return 10;
            case "dining":
                return 8;
            case "onlineShop":
                return 5;
            default:
                return 3;
        }
    }
}
