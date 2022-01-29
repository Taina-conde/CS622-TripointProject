package edu.bu.tbconde.tripoint.models;

import edu.bu.tbconde.tripoint.cards.CreditCard;
import edu.bu.tbconde.tripoint.cards.Wallet;

import java.util.ArrayList;

public class AppModel {
    private Wallet<CreditCard> cardsList = new Wallet<>(2);
    private int pointsBalance;
    private int selectedOption;
    //getters
    public int getSelectedOption() {return selectedOption;}
    public Wallet<CreditCard> getCardsList() {return cardsList;}
    //setters

    public void addCard(CreditCard newCard) {
        cardsList.add(newCard);
    }
    public void addPoints(int points) {pointsBalance += points;}
    public void removePoints(int points) {pointsBalance -= points;}
}
