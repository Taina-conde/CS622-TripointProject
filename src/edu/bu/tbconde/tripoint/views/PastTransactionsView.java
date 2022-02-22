package edu.bu.tbconde.tripoint.views;

import edu.bu.tbconde.tripoint.transactions.Transaction;
import edu.bu.tbconde.tripoint.util.TransInfo;

import java.util.Scanner;

public class PastTransactionsView {
    private Scanner sc = new Scanner(System.in);
    public void printHeader(int pointsBalance, String firstName, String lastName) {
        System.out.printf("You have %,d points.\n", pointsBalance);
        System.out.printf("\n%s %s, your past transactions ...\n", firstName, lastName);
        System.out.println();
        System.out.printf("%-25s %-25s %-25s %-25s %-25s %-25s\n","TYPE", "CARD USED", "CATEGORY", "AMOUNT", "POINTS", "DATE");

    }
    public void printRecord(TransInfo trans) {
        System.out.printf("%-25s %-25s %-25s $%-24.2f %,-25d %-25s\n",
                trans.getType(),
                trans.getCardUsed(),
                trans.getCategory(),
                trans.getAmount(),
                trans.getPoints(),
                trans.getTimestamp()
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
