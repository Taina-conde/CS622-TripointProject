package edu.bu.tbconde.tripoint.app;

import edu.bu.tbconde.tripoint.util.MainMenu;
import edu.bu.tbconde.tripoint.util.RecordsReader;

import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Scanner;
import java.io.BufferedReader;

/**This class handles input and output on the user interface related to his points account*/
public class AppView {
    private Scanner sc;
    private MainMenu menu = new MainMenu();
    public String askUsername() {
        sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        System.out.print("Username: ");
        String username = sc.next();
        //TODO: validate user input
        return username;
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
        RecordsReader.printAllRecords();

    }
    public int askMainMenu() {
        return menu.askMenuOptions();
    }
    public void askTransactionInfo() {
        String cardType = null;
        String category = null;
        double amount = 0;
        String token = null;
        sc = new Scanner(System.in);
        System.out.println("You made a new purchase. \n" +
                "Enter the credit card type used (basic, or preferred), the category (dining, travel, online shopping, or grocery), and the amount separated by a comma. \n" +
                "eg: basic, dining, 40.87\n");

        do {
            System.out.println("Please, enter basic or preferred");
//            while(!sc.hasNext()) {
//                System.out.println("Please, enter only characters.");
//                sc.next();
//            }
            cardType = sc.next().toLowerCase();
            System.out.println("card type" + cardType);

        } while (!(cardType.equals("basic") || cardType.equals("preferred")));
        System.out.println("card type out " + cardType);





    }
    public static void main(String[] args) {
        AppView view = new AppView();
        view.askTransactionInfo();
    }



}
