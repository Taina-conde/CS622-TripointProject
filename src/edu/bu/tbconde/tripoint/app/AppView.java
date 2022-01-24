package edu.bu.tbconde.tripoint.app;

import edu.bu.tbconde.tripoint.exceptions.IncorrectFileNameException;
import edu.bu.tbconde.tripoint.util.RecordsReader;

import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.BufferedReader;

/**This class handles input and output on the user interface related to his points account*/
public class AppView {
    public String askUsername() {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        System.out.print("Username: ");
        //TODO: validate user input
        return sc.next();
    }
    public void displayTransaction(String cardType, String category, double amount, int categoryValue, int points) {
        System.out.printf(
                "You spent $%.2f on %s  using your %s card.\n" +
                        "The %s  card gives you %d points for every $1 spent on %s. \n" +
                        "You earned %,d points in this transaction. \n",
                amount,
                category,
                cardType,
                cardType,
                categoryValue,
                category,
                points);
    }
    public void displayTransactionRecords() {
        try {
            RecordsReader.printAllRecords();
        }
        catch(IncorrectFileNameException e) {
            System.out.println(e);
        }
    }



}
