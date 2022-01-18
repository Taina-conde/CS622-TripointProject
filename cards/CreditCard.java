package cards;

public abstract class CreditCard {
    protected String customer;
    protected static int pointsBal;


    public CreditCard() {

    }
    public CreditCard(String customer) {
        this.customer = customer;

    }
    public CreditCard(String customer, int pointsBal) {
        this.customer = customer;
        this.pointsBal += pointsBal;

    }
    public static int getPointsBal() {
        return pointsBal;
    }
    public void addPoints(int pointsEarned) {
        pointsBal += pointsEarned;
    }



}
