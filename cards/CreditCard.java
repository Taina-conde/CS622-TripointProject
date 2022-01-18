package cards;

public abstract class CreditCard {
    protected String customer;
    protected static int pointsBal;
    protected String type;

    public CreditCard(String type) {
        this.type = type;
    }
    public CreditCard(String type, String customer) {
        this(type);
        this.customer = customer;
    }
    public CreditCard(String customer, int pointsBal) {
        this.customer = customer;
        this.pointsBal += pointsBal;
    }
    public String getType() {
        return type;
    }
    public abstract int getCategoryValue(String category);

    public static int getPointsBal() {
        return pointsBal;
    }
    public void addPoints(int pointsEarned) {
        pointsBal += pointsEarned;
    }
}
