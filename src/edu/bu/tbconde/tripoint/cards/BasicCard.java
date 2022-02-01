package edu.bu.tbconde.tripoint.cards;

public class BasicCard extends CreditCard {
    private final String type = "basic";
    public BasicCard(String customer, int pointsBal) {
        super(customer, pointsBal);
    }
    public BasicCard(String customer) {
        this(customer, 0);
    }
    public BasicCard() {
        this("");
    }
    @Override
    public String getType(){ return type; }

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
    @Override
    public String toString() {
        return type.substring(0,1).toUpperCase() + type.substring(1);
    }
}
