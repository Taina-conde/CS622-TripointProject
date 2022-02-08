package edu.bu.tbconde.tripoint.views;

import edu.bu.tbconde.tripoint.transactions.Transaction;

import java.util.Scanner;

public class PastTransactionsView {
    private Scanner sc = new Scanner(System.in);
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
    public int askMenu(String option1, String option2, String option3) {
        int selected;
        String selectedText;
        System.out.println("\nWhat would you like to do?\n " +
                option1 + option2 + option3 );
        do {
            System.out.println("Please, enter 1, 2, or 3");
            while(!sc.hasNextInt()) {
                System.out.println("Please, enter only numbers.");
                sc.nextLine();
            }
            selected = sc.nextInt();

        } while (!(selected >=1 && selected <=3));
        switch(selected) {
            case 1:
                selectedText = option1;
                break;
            case 2:
                selectedText = option2;
                break;
            default:
                selectedText = option3;
                break;
        }
        System.out.println("You selected: " + selectedText);
        return selected;

    }
}
