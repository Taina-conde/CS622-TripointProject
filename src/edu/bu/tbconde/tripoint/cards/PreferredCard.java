package edu.bu.tbconde.tripoint.cards;

public class PreferredCard extends CreditCard {
    private final String type = "preferred";
    public PreferredCard(String customer, int pointsBal) {
        super( customer, pointsBal);
    }
    public PreferredCard(String customer) {
        this(customer, 0);
    }
    public PreferredCard() {
        this("");
    }
    @Override
    public String getType() {return type;}
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
    @Override
    public String toString() {
        return type.substring(0,1).toUpperCase() + type.substring(1);
    }
}
