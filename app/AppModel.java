package app;

import transactions.Transaction;
import cards.CreditCard;

import java.util.ArrayList;
/**This class stores the data needed to use the points account*/
public class AppModel {
    private ArrayList<CreditCard> cardsList;
    private String customer;
    private int pointsBalance;
    private ArrayList<Transaction> transactionsRecord;

    //getters
    public ArrayList<CreditCard> getCardsList() {
        return cardsList;
    }
    public String getCustomer() {
        return customer;
    }
    public int getPointsBalance() {return pointsBalance;}
    public ArrayList<Transaction> getTransactionsRecord() {return transactionsRecord;}

    //setters
    public void addCard(CreditCard newCard) {
        cardsList.add(newCard);
    }
    public void setCustomer(String name) {customer = name;}
    public void addPoints(int points) {pointsBalance += points;}
    public void removePoints(int points) {pointsBalance -= points;}
    public void addTransaction(Transaction newTrans) {transactionsRecord.add(newTrans);}

}
