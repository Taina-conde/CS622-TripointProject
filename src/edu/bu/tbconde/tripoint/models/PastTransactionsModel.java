package edu.bu.tbconde.tripoint.models;

public class PastTransactionsModel {
    private String cardType;
    private String category;
    private String amount;
    private String points;
    private int selectedOption;
    private String option1;
    private String option2;
    private String option3;

    public PastTransactionsModel() {
        option1 = "1.Show purchase transactions \n ";
        option2 = "2.Show redeem transactions \n ";
        option3 = "3.Show all transactions \n ";
    }

    //getters
    public String getCategory() {return category;}
    public String getAmount() {return amount;}
    public String getCardType() {return cardType;}
    public String getPoints(){return points;}
    public int getSelectedOption() {return selectedOption;}
    public String getOption1() {return option1;}
    public String getOption2() { return option2;}
    public String getOption3() { return option3;}

    //setters
    public void setCategory(String category) {this.category = category;}
    public void setCardType(String cardType) {this.cardType = cardType;}
    public void setAmount(String amount) {this.amount= amount;}
    public void setPoints(String points) { this.points = points;}
    public void setSelectedOption(int selected) {this.selectedOption = selected;}




}
