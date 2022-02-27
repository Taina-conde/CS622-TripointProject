package edu.bu.tbconde.tripoint.models;

import edu.bu.tbconde.tripoint.cards.CreditCard;
import edu.bu.tbconde.tripoint.config.*;

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
    private ArrayList<UserPreferences<Preference>> userPrefsList = new ArrayList<UserPreferences<Preference>>();


    public AppModel(int capacity) {
        wallet = new Wallet<>(capacity);

    }
    public AppModel(int capacity, String path) {
        wallet = new Wallet<>(capacity);

    }
    public AppModel(Thread initThread, FutureTask<ArrayList<UserPreferences<Preference>>> future) {
        wallet = new Wallet<>(2);

    }
    //getters
    public User getUser() {return user;}
    public Wallet<CreditCard> getWallet() {return wallet;}
    public int getPointsBalance() {return pointsBalance;}
    public UserPreferences getUserPrefs() {return userPrefs;}
    public ArrayList<UserPreferences<Preference>> getUserPrefsList() {return userPrefsList;}

    //setters
    public void setUser(User user) {this.user = user;}
    public void addCard(CreditCard newCard) {
        wallet.add(newCard);
    }
    public void setPointsBalance(int points) {pointsBalance = points;}
    public void setUserPrefs(UserPreferences userPrefs) {this.userPrefs = userPrefs;}
    public void setUserPrefsList(ArrayList<UserPreferences<Preference>> userPrefsList) {this.userPrefsList = userPrefsList;}

    public ArrayList<UserPreferences<Preference>> initializePreferences(FutureTask<ArrayList<UserPreferences<Preference>>> future) throws ExecutionException, InterruptedException {
        userPrefsList = future.get();
        if (userPrefsList.size() == 0) {
            userPrefs = new UserPreferences(new CurrencyPreference(user.getId()), new OrderByPreference(user.getId()));
        }
        return userPrefsList;
    }
}
