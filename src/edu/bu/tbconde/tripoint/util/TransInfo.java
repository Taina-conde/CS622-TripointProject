package edu.bu.tbconde.tripoint.util;

import edu.bu.tbconde.tripoint.transactions.Transaction;

import java.sql.Timestamp;

public class TransInfo {
    private String firstName;
    private String lastName;
    private String type;
    private String category;
    private String cardUsed;
    private double amount;
    private int points;
    private Timestamp timestamp;

    public TransInfo(String firstName, String lastName, String type, String cardUsed, String category, double amount, int points, Timestamp timestamp) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
        this.category = category;
        this.cardUsed = cardUsed;
        this.amount = amount;
        this.points = points;
        this. timestamp = timestamp;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getCardUsed() {
        return cardUsed;
    }

    public double getAmount() {
        return amount;
    }

    public int getPoints() {
        return points;
    }

    public String getCategory() {
        return category;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public String getType() {
        return type;
    }
}
