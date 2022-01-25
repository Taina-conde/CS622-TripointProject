package edu.bu.tbconde.tripoint.app;

import edu.bu.tbconde.tripoint.transactions.CategoryTransaction;
import edu.bu.tbconde.tripoint.transactions.Transaction;
import edu.bu.tbconde.tripoint.cards.CreditCard;
import edu.bu.tbconde.tripoint.util.RecordsWriter;

import java.util.ArrayList;
/**This class stores the data needed to use the points account*/
public class AppModel {
    private ArrayList<CreditCard> cardsList = new ArrayList<>();
    private String customer;
    private Transaction currentTrans;
    private int pointsBalance;
    private int optionSelected;
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
    public int getOptionSelected() {return optionSelected;}
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
    public void setOptionSelected(int selected) { optionSelected = selected;}
    public void addPoints(int points) {pointsBalance += points;}
    public void removePoints(int points) {pointsBalance -= points;}
    public void saveTransaction() {
        String cardType = currentTrans.getCard().getType();
        String category = currentTrans.getCategory();
        double amount = currentTrans.getAmount();
        int points = currentTrans.getPoints();
        String transaction = String.format("%s, %s, %.2f, %,d", cardType, category,amount, points);

        RecordsWriter.writeRecord(transaction);

        transactionsRecord.add(currentTrans);
        if (currentTrans instanceof CategoryTransaction) {
            addPoints(points);
        }
        else {
            removePoints(points);
        }
    }

}
