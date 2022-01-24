package edu.bu.tbconde.tripoint.cards;

public class PreferredCard extends CreditCard {
    public PreferredCard(String customer, int pointsBal) {
        super("preferred", customer, pointsBal);
    }
    public PreferredCard(String customer) {
        this(customer, 0);
    }
    public PreferredCard() {
        this("");
    }

    @Override
    public int getCategoryValue(String category) {
        int result;
        switch (category) {
            case "travel":
                result = 10;
                break;
            case "dining":
                result = 8;
                break;
            case "onlineShop":
                result = 5;
                break;
            default:
                result = 3;
                break;
        }
        return result;
    }
}
