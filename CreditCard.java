public abstract class CreditCard {
    protected String customer;
    protected int pointsBal;


    public CreditCard() {

    }
    public CreditCard(String customer) {
        this.customer = customer;

    }
    public abstract int calculatePoints();


}
