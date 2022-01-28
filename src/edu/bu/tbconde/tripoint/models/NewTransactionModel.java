package edu.bu.tbconde.tripoint.models;

public class NewTransactionModel {
    private String cardType;
    private String category;
    private double amount;

    //getters
    public String getCardType() {return cardType;}
    public String getCategory() {return category;
    }
    public double getAmount() {return amount;}

    //setters
    public void setAmount(double amount) {this.amount = amount; }
    public void setCategory(String category) {this.category = category;}
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
}
