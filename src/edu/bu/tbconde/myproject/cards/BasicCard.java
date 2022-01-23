package edu.bu.tbconde.myproject.cards;

public class BasicCard extends CreditCard {
    public BasicCard(String customer, int pointsBal) {
        super("basic", customer, pointsBal);
    }
    public BasicCard(String customer) {
        this(customer, 0);
    }
    public BasicCard() {
        this("");
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
