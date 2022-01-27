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
        sc = new Scanner(System.in);
        System.out.print("Username: ");
        return sc.nextLine();
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
    public void askTransactionInfo(String cardType, String category, double amount) {
        sc = new Scanner(System.in);
        System.out.println("You made a new purchase. \n" +
                "Please enter the credit card type used (basic, or preferred)");
        cardType = sc.nextLine().trim().replaceAll("\\p{P}", "").toLowerCase();
        while (!(cardType.equals("basic") || cardType.equals("preferred"))){
            System.out.println(cardType + " is not a valid type.\n" + "Please, enter basic or preferred");
            cardType = sc.nextLine().trim().replaceAll("\\p{P}", "").toLowerCase();
        }
        System.out.println("card type out " + cardType);
        System.out.println("Next, please enter the category of te purchase (dining, travel, online shopping, or grocery)");
        category = sc.nextLine().trim().replaceAll("\\p{P}", "").toLowerCase();
        while (!(category.equals("dining")
                || category.equals("travel")
                || category.equals("online shopping")
                || category.equals("grocery"))
        ) {
            System.out.println(category + " is not a valid category.\n" +
                    "Please, enter one between dining, travel,  online shopping, or grocery");
            category = sc.nextLine().trim().replaceAll("\\p{P}", "").toLowerCase();
        }
        System.out.println("Finally, enter the amount purchased");
        do {
            System.out.println("Please enter a positive number greater than 0");
            while(!sc.hasNextDouble()) {
                System.out.println("Please enter a number");
                sc.nextLine();
            }
            amount = sc.nextDouble();
        } while (!(amount > 0));
        System.out.println("amount: " + amount);

    }

    public static void main(String[] args) {
        AppView view = new AppView();
    }



}
