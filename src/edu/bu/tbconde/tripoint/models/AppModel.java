package edu.bu.tbconde.tripoint.models;

import edu.bu.tbconde.tripoint.cards.CreditCard;

import java.util.ArrayList;

public class AppModel {
    private ArrayList<CreditCard> cardsList = new ArrayList<>();
    private int pointsBalance;
    //setters
    public void addCard(CreditCard newCard) {
        cardsList.add(newCard);
    }
    public void addPoints(int points) {pointsBalance += points;}
    public void removePoints(int points) {pointsBalance -= points;}
}
