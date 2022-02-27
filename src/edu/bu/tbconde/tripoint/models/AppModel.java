package edu.bu.tbconde.tripoint.models;

import edu.bu.tbconde.tripoint.cards.CreditCard;
import edu.bu.tbconde.tripoint.config.CurrencyPreference;
import edu.bu.tbconde.tripoint.config.InitializePreferencesThread;
import edu.bu.tbconde.tripoint.config.UserPreferences;
import edu.bu.tbconde.tripoint.transactions.Transaction;
import edu.bu.tbconde.tripoint.util.InitializeRecordsThread;
import edu.bu.tbconde.tripoint.util.User;
import edu.bu.tbconde.tripoint.util.Wallet;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class AppModel {
    private User user = new User();
    private Wallet<CreditCard> wallet;
    private int pointsBalance;
    private UserPreferences userPrefs;
    private ArrayList<UserPreferences> userPrefsList = new ArrayList<UserPreferences>();
    private FutureTask<ArrayList<UserPreferences>> future;
    private Thread initThread;

    public AppModel(int capacity) {
        //default user preference
        wallet = new Wallet<>(capacity);
        future = new FutureTask<ArrayList<UserPreferences>>(new InitializePreferencesThread(user.getId()));
        //start thread that will read the file to get the arraylist of user preferences
        initThread = new Thread(future);
        initThread.start();
    }
    public AppModel(int capacity, String path) {
        wallet = new Wallet<>(capacity);
        future = new FutureTask<ArrayList<UserPreferences>>(new InitializePreferencesThread(user.getId(), path));
        //start thread that will read the file to get the arraylist of user preferences
        initThread = new Thread(future);
        initThread.start();
    }
    public AppModel(Thread initThread, FutureTask<ArrayList<UserPreferences>> future) {
        wallet = new Wallet<>(2);
        this.initThread = initThread;
        this.future = future;
    }
    //getters
    public User getUser() {return user;}
    public Wallet<CreditCard> getWallet() {return wallet;}
    public int getPointsBalance() {return pointsBalance;}
    public ArrayList<UserPreferences> getUserPrefsList() {return userPrefsList;}

    //setters
    public void setUser(User user) {this.user = user;}
    public void addCard(CreditCard newCard) {
        wallet.add(newCard);
    }
    public void addPoints(int points) {pointsBalance += points;}
    public void removePoints(int points) {pointsBalance -= points;}
    public void setPointsBalance(int points) {pointsBalance = points;}
    public void setUserPrefsList(ArrayList<UserPreferences> userPrefsList) {this.userPrefsList = userPrefsList;}

    public ArrayList<UserPreferences> initializePreferences() throws ExecutionException, InterruptedException {
        userPrefsList = future.get();
        return userPrefsList;
    }
}
