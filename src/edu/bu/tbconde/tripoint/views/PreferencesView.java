package edu.bu.tbconde.tripoint.views;

import java.util.Scanner;

public class PreferencesView {
    private Scanner sc = new Scanner(System.in);

    public int preferencesMenu() {
        int selected;
        System.out.println("What would you like to do? \n ");
        System.out.println("1.Load saved preferences  \n ");
        System.out.println("2.Set new preference \n ");
        do {
            System.out.println("Please, enter 1, or 2.");
            while(!sc.hasNextInt()) {
                System.out.println("Please, enter only numbers.");
                sc.nextLine();
            }
            selected = sc.nextInt();

        } while (!(selected >=1 && selected <=2));
        return selected;
    }

    public String askCurrency() {
        int selected;
        System.out.println("Set currency: \n ");
        System.out.println("1.Dollar  \n ");
        System.out.println("2.Euro \n ");
        do {
            System.out.println("Please, enter 1, or 2.");
            while(!sc.hasNextInt()) {
                System.out.println("Please, enter only numbers.");
                sc.nextLine();
            }
            selected = sc.nextInt();

        } while (!(selected >=1 && selected <=2));
        if (selected == 1) {
            return "dollar";
        }
        return "euro";
    }
    public String askOrderBy() {
        int selected;
        System.out.println("Order past transactions by: \n ");
        System.out.println("1.Most recent  \n ");
        System.out.println("2.Oldest \n ");
        System.out.println("3.Greatest amount \n ");
        System.out.println("4.Lowest amount \n ");
        System.out.println("5.Type \n ");

        do {
            System.out.println("Please, enter 1, 2, 3, 4, or 5.");
            while(!sc.hasNextInt()) {
                System.out.println("Please, enter only numbers.");
                sc.nextLine();
            }
            selected = sc.nextInt();

        } while (!(selected >=1 && selected <=5));
        switch(selected) {
            case 1:
                return "timestamp DESC";
            case 2:
                return "timestamp ASC";
            case 3:
                return "amount DESC";
            case 4:
                return "amount ASC";
            default:
                return "type";
        }
    }
}
