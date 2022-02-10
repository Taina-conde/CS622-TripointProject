package edu.bu.tbconde.tripoint.models;

import edu.bu.tbconde.tripoint.cards.CreditCard;
import edu.bu.tbconde.tripoint.transactions.Transaction;
import edu.bu.tbconde.tripoint.util.InitializeRecordsThread;
import edu.bu.tbconde.tripoint.util.Wallet;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class AppModel {
    private Wallet<CreditCard> wallet;
    private int pointsBalance;
    private ArrayList<Transaction> records = new ArrayList<Transaction>();
    private ArrayList<Transaction> purchaseRecords = new ArrayList<Transaction>();
    private ArrayList<Transaction> redeemRecords = new ArrayList<Transaction>();
    private FutureTask<ArrayList<Transaction>> future;
    private Thread initThread;

    public AppModel(int capacity) {
        wallet = new Wallet<>(capacity);
        future = new FutureTask<ArrayList<Transaction>>(new InitializeRecordsThread());
        //start thread that will check that reads the file to get the arraylist of transactions
        initThread = new Thread(future);
        initThread.start();
    }
    //getters
    public ArrayList<Transaction> getPurchaseRecords() {return purchaseRecords;}
    public ArrayList<Transaction> getRedeemRecords() {return redeemRecords;}
    public ArrayList<Transaction> getRecords() {return records;}
    public Wallet<CreditCard> getWallet() {return wallet;}
    public int getPointsBalance() {return pointsBalance;}

    //setters
    public void setPurchaseRecords(ArrayList<Transaction> records) {purchaseRecords = records;}
    public void setRedeemRecords(ArrayList<Transaction> records) {redeemRecords = records;}
    public void setRecords(ArrayList<Transaction> records) {this.records = records;}
    public void addTrans(Transaction newTrans) {records.add(newTrans);}
    public void addCard(CreditCard newCard) {
        wallet.add(newCard);
    }
    public void addPoints(int points) {pointsBalance += points;}
    public void removePoints(int points) {pointsBalance -= points;}

    public ArrayList<Transaction> initializeRecords() {
        try {
            records = future.get();
            for (Transaction trans: records) {
                if (trans.getType().equals("redeem")) {
                    removePoints(trans.getPoints());
                } else {
                    addPoints(trans.getPoints());
                }
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return records;
    }
}
