package edu.bu.tbconde.myproject.cards;

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
