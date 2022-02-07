package edu.bu.tbconde.tripoint.views;

import edu.bu.tbconde.tripoint.transactions.Transaction;

public class PastTransactionsView {

    public void printHeader(int pointsBalance) {
        System.out.printf("You have %,d points.\n", pointsBalance);
        System.out.println("\nYour past transactions ...");
        System.out.println();
        System.out.printf("%-30s %-30s %-30s %-30s %-30s\n","TYPE", "CARD USED", "CATEGORY", "AMOUNT", "POINTS");

    }
    public void printRecord(Transaction trans) {
        int points;
        if (trans.getType().equals("redeem")) {
            points = -trans.getPoints();
        } else {
            points = trans.getPoints();
        }
        System.out.printf("%-30s %-30s %-30s $%-29.2f %,-30d\n",
                trans.getType(),
                trans.getCardType(),
                trans.getCategory(),
                trans.getAmount(),
                points
        );
    }
}
