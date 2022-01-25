package edu.bu.tbconde.tripoint.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainMenu {
    private final Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    public MainMenu(){}
    public int askMenuOptions() {
        int selected;
        System.out.println("What would you like to do?\n " +
                "1.Register a new purchase \n " +
                "2.View past transactions \n "+
                "3.Redeem points \n"
                );
        do {
            System.out.println("Please, enter 1, 2 or 3.");
            while(!sc.hasNextInt()) {
                System.out.println("Please, enter only numbers.");
                sc.next();
            }
            selected = sc.nextInt();

        } while (!(selected >=1 && selected <=3));
        return selected;
    }
    public static void main(String[] args) {
        MainMenu menu = new MainMenu();
        int choice = menu.askMenuOptions();
        System.out.println("choice: " + choice);

    }


}
