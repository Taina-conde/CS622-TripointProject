package edu.bu.tbconde.tripoint.models;

import edu.bu.tbconde.tripoint.cards.CreditCard;
import edu.bu.tbconde.tripoint.transactions.CategoryTransaction;
import edu.bu.tbconde.tripoint.transactions.Transaction;

import java.util.ArrayList;

public class NewTransactionModel{
    private ArrayList<CreditCard> cardsList;
    private String cardType;
    private String category;
    private double amount;
    private Transaction currTrans;
    private int points;
    private int catValue;
    public NewTransactionModel(ArrayList<CreditCard> cardsList) {
        this.cardsList = cardsList;
    }

    //getters'
    public ArrayList<CreditCard> getCardsList() {return cardsList;}
    public int getPoints() {return points;}
    public int getCatValue() {return catValue;}
    public String getCardType() {return cardType;}
    public String getCategory() {return category;
    }
    public double getAmount() {return amount;}

    //setters
    public void setAmount(double amount) {this.amount = amount; }
    public void setCardsList(ArrayList<CreditCard> cardsList) { this.cardsList = cardsList;}
    public void setCategory(String category) {this.category = category;}
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
    public void setCurrTrans(Transaction currTrans) {
        this.currTrans = currTrans;

    }
    public void createNewTransaction() {
        for (CreditCard card: cardsList) {
            if (card.getType().equals(cardType)) {
                currTrans = new CategoryTransaction(card, category, amount);
            }
        }
        this.points = currTrans.calculatePoints();
        this.catValue = currTrans.getCard().getCategoryValue(this.category);
    }
}
