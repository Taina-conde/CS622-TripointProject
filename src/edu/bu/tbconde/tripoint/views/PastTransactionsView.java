package edu.bu.tbconde.tripoint.views;

import edu.bu.tbconde.tripoint.util.RecordsReader;

public class PastTransactionsView {
    private RecordsReader reader = new RecordsReader();
    public void printAllRecords() {
        reader.printAllRecords();
    }

    private void printHeader() {
        System.out.println("Your past transactions ...");
        System.out.println();
        System.out.printf("%-30s %-30s %-30s %-30s\n","CARD USED", "CATEGORY", "AMOUNT", "POINTS");


    }
}
