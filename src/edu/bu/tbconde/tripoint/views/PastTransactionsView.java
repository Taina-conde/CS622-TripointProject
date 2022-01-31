package edu.bu.tbconde.tripoint.views;

import edu.bu.tbconde.tripoint.util.RecordsReader;

import java.util.ArrayList;

public class PastTransactionsView {
    private RecordsReader reader = new RecordsReader();

    public void printHeader() {
        System.out.println("Your past transactions ...");
        System.out.println();
        System.out.printf("%-30s %-30s %-30s %-30s\n","CARD USED", "CATEGORY", "AMOUNT", "POINTS");

    }
    public void printRecord(String card, String category, String amount, String points) {
        System.out.printf("%-30s %-30s %-30s %-30s\n",
                card,
                category,
                amount,
                points);
    }
}
