package edu.bu.tbconde.tripoint.models;

import edu.bu.tbconde.tripoint.cards.CreditCard;
import edu.bu.tbconde.tripoint.transactions.Transaction;
import edu.bu.tbconde.tripoint.util.Wallet;

import java.util.ArrayList;

public class AppModel {
    private Wallet<CreditCard> wallet;
    private int pointsBalance;
    private int selectedOption;
    private ArrayList<Transaction> records = new ArrayList<Transaction>();
    public AppModel(int capacity) {
        wallet = new Wallet<>(capacity);
    }
    //getters
    public ArrayList<Transaction> getRecords() {return records;}
    public int getSelectedOption() {return selectedOption;}
    public Wallet<CreditCard> getWallet() {return wallet;}

    //setters
    public void setRecords(ArrayList<Transaction> records) {this.records = records;}
    public void addTrans(Transaction newTrans) {records.add(newTrans);}
    public void addCard(CreditCard newCard) {
        wallet.add(newCard);
    }
    public void addPoints(int points) {pointsBalance += points;}
    public void removePoints(int points) {pointsBalance -= points;}
}
