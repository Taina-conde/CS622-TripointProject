package edu.bu.tbconde.tripoint.models;

import edu.bu.tbconde.tripoint.util.RecordsReader;

import java.util.ArrayList;

public class PastTransactionsModel {
    private RecordsReader reader;
    private String cardType;
    private String category;
    private String amount;
    private String points;
    public PastTransactionsModel() {
        reader = new RecordsReader();
    }

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

    //read transactionsRecord.txt file and collect each transaction info
    public int readAllRecords() {
        int count = 0;
        ArrayList<String> lines = reader.readLine();
        if (lines.size() == 0) {
            System.out.println("You haven't made any transactions yet.");
            return count;
        }
        else {
            //printHeader();
            for (String line: lines) {
                String[] tokens = line.split(",");
                if (tokens.length == 4) {
                    this.cardType = tokens[0];
                    this.category = tokens[1];
                    this.amount = tokens[2];
                    this.points = tokens[3];
                }
                count++;
            }
            return count;
        }
    }

}
