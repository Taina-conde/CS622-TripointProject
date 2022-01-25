package edu.bu.tbconde.tripoint.app;

import edu.bu.tbconde.tripoint.exceptions.IncorrectFileNameException;
import edu.bu.tbconde.tripoint.util.MainMenu;
import edu.bu.tbconde.tripoint.util.RecordsReader;

import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.BufferedReader;

/**This class handles input and output on the user interface related to his points account*/
public class AppView {
    private Scanner sc;
    public String askUsername() {
        sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
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
            e.printStackTrace();
        }
    }
    public int askMainMenu() {
        MainMenu menu = new MainMenu();
        return menu.askMenuOptions();
    }
    public void askTransactionInfo() {
        String cardType = null;
        String category = null;
        double amount = 0;
        sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        sc.useDelimiter(", ");
        System.out.println("You made a new purchase. " +
                "Enter the credit card type used (basic, or preferred), the category (dining, travel, online shopping, or grocery), and the amount separated by a comma. \n" +
                "eg: basic, dining, 40.87\n");
        while (!sc.hasNext()) {
            System.out.println("next:" + sc.next());



        }

        System.out.println("card:" + cardType);




    }
    public static void main(String[] args) {
        AppView app = new AppView();
        app.askTransactionInfo();
    }



}
