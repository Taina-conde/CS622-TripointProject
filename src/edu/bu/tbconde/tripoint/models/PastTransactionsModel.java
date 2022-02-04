package edu.bu.tbconde.tripoint.models;

public class PastTransactionsModel {
    private String cardType;
    private String category;
    private String amount;
    private String points;

    //getters
    public String getCategory() {return category;}
    public String getAmount() {return amount;}
    public String getCardType() {return cardType;}
    public String getPoints(){return points;}

    //setters
    public void setCategory(String category) {this.category = category;}
    public void setCardType(String cardType) {this.cardType = cardType;}
    public void setAmount(String amount) {this.amount= amount;}
    public void setPoints(String points) { this.points = points;}

}
