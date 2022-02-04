package edu.bu.tbconde.tripoint.models;

import edu.bu.tbconde.tripoint.transactions.Transaction;
import edu.bu.tbconde.tripoint.util.RecordsReader;

import java.io.IOException;
import java.util.ArrayList;

public class PastTransactionsModel {
    private RecordsReader reader;
    private String cardType;
    private String category;
    private String amount;
    private String points;
    private ArrayList<Transaction> records;
    public PastTransactionsModel() {
        reader = new RecordsReader();
        records = new ArrayList<Transaction>();
    }

    //getters
    public String getCategory() {return category;}
    public String getAmount() {return amount;}
    public String getCardType() {return cardType;}
    public String getPoints(){return points;}
    public ArrayList<Transaction> getRecords() {
        return records;
    }

    //setters
    public void setCategory(String category) {this.category = category;}
    public void setCardType(String cardType) {this.cardType = cardType;}
    public void setAmount(String amount) {this.amount= amount;}
    public void setPoints(String points) { this.points = points;}

    //read transactionsRecord.dat file
    public int readAllRecords() {
        try {
            this.records = reader.readRecords();
        }
        catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return records.size();
    }
}
