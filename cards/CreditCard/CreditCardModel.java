package cards.CreditCard;

import transactions.Transaction;

import java.util.ArrayList;
/**This class stores the data in the credit card account */
public abstract class CreditCardModel {
    protected String customer;
    protected static int pointsBal;
    protected String type;
    protected ArrayList<Transaction> transactionsRecord;
    public CreditCardModel(String type, String customer, int pointsBal) {
        this.type = type;
        this.customer = customer;
        this.pointsBal += pointsBal;
    }
    public CreditCardModel(String type, String customer) {
        this(type, customer, 0);
    }
    public CreditCardModel(String type) {
        this(type, "");
    }
    public CreditCardModel() {
        this("");
    }

    //getters
    public String getType() {return type;}
    public static int getPointsBal() {return pointsBal;}
    public String getCustomer() {return customer;}
    public ArrayList<Transaction> getTransactionsRecord() {return transactionsRecord;}

    //setters
    public void setType(String type) { this.type = type;}
    public static void addPoints(int earnedPoints) {pointsBal += earnedPoints;}
    public static void removePoints(int redeemedPoints) {pointsBal -= redeemedPoints;}
    public void setCustomer(String customer) { this.customer = customer;}
    public void addTransaction(Transaction newTransaction) {transactionsRecord.add(newTransaction);}

    public abstract int getCategoryValue(String category);
}
