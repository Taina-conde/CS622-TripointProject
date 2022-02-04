package edu.bu.tbconde.tripoint.views;

import edu.bu.tbconde.tripoint.transactions.Transaction;

public class PastTransactionsView {

    public void printHeader() {
        System.out.println("Your past transactions ...");
        System.out.println();
        System.out.printf("%-30s %-30s %-30s %-30s\n","CARD USED", "CATEGORY", "AMOUNT", "POINTS");

    }
    public void printRecord(Transaction trans) {
        System.out.printf("%-30s %-30s %-30.2f %,-30d\n",
                trans.getCard(),
                trans.getCategory(),
                trans.getAmount(),
                trans.getPoints()
        );
    }
}
