package app;

import transactions.CategoryTransaction;
import transactions.Transaction;
import cards.CreditCard;

import java.util.ArrayList;
/**This class stores the data needed to use the points account*/
public class AppModel {
    private ArrayList<CreditCard> cardsList = new ArrayList<>();
    private String customer;
    private Transaction currentTrans;
    private int pointsBalance;
    private ArrayList<Transaction> transactionsRecord = new ArrayList<>();


    //getters
    public ArrayList<CreditCard> getCardsList() {
        return cardsList;
    }
    public String getCustomer() {
        return customer;
    }
    public Transaction getCurrentTrans() {
        return currentTrans;
    }
    public int getPointsBalance() {return pointsBalance;}
    public ArrayList<Transaction> getTransactionsRecord() {return transactionsRecord;}

    //setters
    public void addCard(CreditCard newCard) {
        cardsList.add(newCard);
    }
    public void setCustomer(String name) {customer = name;}
    public void setCurrentTrans(String cardType, String category, double amount ) {
        for (CreditCard card: cardsList) {
            if (card.getType().equals(cardType)) {
                currentTrans = new CategoryTransaction(card, category, amount);
            }
        }
    }
    public void addPoints(int points) {pointsBalance += points;}
    public void removePoints(int points) {pointsBalance -= points;}
    public void addTransaction(Transaction newTrans) {transactionsRecord.add(newTrans);}

}
