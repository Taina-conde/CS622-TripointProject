public class TravelTransaction extends Transaction {
    private final String category = "travel";
    public TravelTransaction() {
        super();
    }
    public TravelTransaction(CreditCard card,  double amount) {
        super(card, amount);
    }
    public String getCategory() {
        return category;
    }
    public int calculatePoints(){

    }

}
