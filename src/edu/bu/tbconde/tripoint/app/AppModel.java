package edu.bu.tbconde.tripoint.app;

import edu.bu.tbconde.tripoint.transactions.CategoryTransaction;
import edu.bu.tbconde.tripoint.transactions.Transaction;
import edu.bu.tbconde.tripoint.cards.Wallet;
import edu.bu.tbconde.tripoint.cards.CreditCard;
import edu.bu.tbconde.tripoint.util.RecordsWriter;

import java.util.ArrayList;
/**This class stores the data needed to use the points account*/
public class AppModel {
    private Wallet<CreditCard> wallet;
    private RecordsWriter writer;
    private String customer;
    private Transaction currTrans;
    private int pointsBalance;
    private ArrayList<Transaction> transactionsRecord = new ArrayList<>();

    public AppModel(int capacity) {
        wallet = new Wallet<>(capacity);
        writer = new RecordsWriter();
    }


    //getters
    public Wallet<CreditCard> getWallet() {
        return wallet;
    }
    public String getCustomer() {
        return customer;
    }
    public Transaction getCurrentTrans() {
        return currTrans;
    }
    public int getPointsBalance() {return pointsBalance;}
    public ArrayList<Transaction> getTransactionsRecord() {return transactionsRecord;}

    //setters
    public void addCard(CreditCard newCard) {
        wallet.add(newCard);
    }
    public void setCustomer(String name) {customer = name;}
    public void setCurrentTrans(String cardType, String category, double amount ) {
        for (int i = 0; i < wallet.size(); i++) {
            CreditCard card = wallet.getCard(i);
            if (card.getType().equals(cardType)) {
                currTrans = new CategoryTransaction(card, category, amount);
            }
        }
    }
    public void addPoints(int points) {pointsBalance += points;}
    public void removePoints(int points) {pointsBalance -= points;}
    public void saveTransaction() {
        boolean isWritten;
        String cardType = currTrans.getCard().getType();
        String category = currTrans.getCategory();
        double amount = currTrans.getAmount();
        int points = currTrans.getPoints();
        String transaction = String.format("%s, %s, %.2f, %,d", cardType, category,amount, points);

        isWritten = writer.writeRecord(transaction);

        if (isWritten) {
            transactionsRecord.add(currTrans);
            if (currTrans instanceof CategoryTransaction) {
                addPoints(points);
            }
            else {
                removePoints(points);
            }
        } else {
            System.out.println("A problem occurred. Please, try again");
        }

    }

}
