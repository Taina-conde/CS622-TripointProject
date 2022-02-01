package edu.bu.tbconde.tripoint.cards;

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

    @Override
    public int getCategoryValue(String category) {
        int result;
        switch (category) {
            case "travel":
                result = 5;
                break;
            case "dining":
                result = 3;
                break;
            case "onlineShop":
                result = 10;
                break;
            default:
                result = 8;
                break;
        }
        return result;
    }
    public String toString() {
        return
    }
}
