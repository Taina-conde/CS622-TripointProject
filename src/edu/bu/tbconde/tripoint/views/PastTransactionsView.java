package edu.bu.tbconde.tripoint.views;

public class PastTransactionsView {

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
