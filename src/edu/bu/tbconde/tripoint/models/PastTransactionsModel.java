package edu.bu.tbconde.tripoint.models;

import edu.bu.tbconde.tripoint.util.RecordsReader;

import java.util.ArrayList;

public class PastTransactionsModel {
    private RecordsReader reader;
    private String cardType;
    private String category;
    private String amount;
    private String points;
    private ArrayList<String> records;
    public PastTransactionsModel() {
        reader = new RecordsReader();
        records = new ArrayList<>();
    }

    //getters
    public String getCategory() {return category;}
    public String getAmount() {return amount;}
    public String getCardType() {return cardType;}
    public String getPoints(){return points;}
    public ArrayList<String> getRecords() {
        return records;
    }

    //setters
    public void setCategory(String category) {this.category = category;}
    public void setCardType(String cardType) {this.cardType = cardType;}
    public void setAmount(String amount) {this.amount= amount;}
    public void setPoints(String points) { this.points = points;}
    public void setRecords(ArrayList<String> records) {
        this.records = records;
    }

    //read transactionsRecord.txt file
    public int readAllRecords() {
        this.records = reader.readLines();
        return records.size();
    }
}
