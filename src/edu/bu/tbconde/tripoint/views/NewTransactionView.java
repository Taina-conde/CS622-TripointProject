package edu.bu.tbconde.tripoint.views;

import java.util.Scanner;

public class NewTransactionView {
    private Scanner sc = new Scanner(System.in);
    public String askCardType() {
        String cardType;
        System.out.println("Please enter the credit card type used (basic, or preferred)");
        cardType = sc.nextLine().trim().replaceAll("\\p{P}", "").toLowerCase();
        while (!(cardType.equals("basic") || cardType.equals("preferred"))){
            System.out.println(cardType + " is not a valid type.\n" + "Please, enter basic or preferred");
            cardType = sc.nextLine().trim().replaceAll("\\p{P}", "").toLowerCase();
        }
        return cardType;
    }
    public String askCategory() {
        String category;
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
        return category;

    }
    public double askAmount() {
        double amount;
        do {
            System.out.println("Please enter a positive number greater than 0");
            while(!sc.hasNextDouble()) {
                System.out.println("Please enter a number");
                sc.nextLine();
            }
            amount = sc.nextDouble();
        } while (!(amount > 0));
        return amount;
    }
    public void displayTransaction(String cardType, String category, double amount, int categoryValue, int points) {
        System.out.printf(
                "\nYou spent $%.2f on %s  using your %s card.\n" +
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
}
