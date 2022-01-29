package edu.bu.tbconde.tripoint.models;

import edu.bu.tbconde.tripoint.cards.CreditCard;
import edu.bu.tbconde.tripoint.cards.Wallet;

import java.util.ArrayList;

public class AppModel {
    private Wallet<CreditCard> wallet;
    private int pointsBalance;
    private int selectedOption;
    public AppModel(int capacity) {
        wallet = new Wallet<>(capacity);
    }
    //getters
    public int getSelectedOption() {return selectedOption;}
    public Wallet<CreditCard> getWallet() {return wallet;}
    //setters

    public void addCard(CreditCard newCard) {
        wallet.add(newCard);
    }
    public void addPoints(int points) {pointsBalance += points;}
    public void removePoints(int points) {pointsBalance -= points;}
}
