package edu.bu.tbconde.tripoint.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainMenu {
    private Scanner sc;
    private String option1 = "1.Register a new purchase \n ";
    private String option2 = "2.View past transactions \n ";
    private String option3 = "3.Redeem points \n ";
    private String option4 = "4.Exit \n";
    private String selectedText;
    private int selected;
    public MainMenu(){
        sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    }
    public int askMenuOptions() {
        System.out.println("\nWhat would you like to do?\n " +
              option1 + option2 + option3 + option4);
        do {
            System.out.println("Please, enter 1, 2, 3, or 4.");
            while(!sc.hasNextInt()) {
                System.out.println("Please, enter only numbers.");
                sc.nextLine();
            }
            selected = sc.nextInt();

        } while (!(selected >=1 && selected <=4));
        switch(selected) {
            case 1:
                selectedText = option1;
                break;
            case 2:
                selectedText = option2;
                break;
            case 3:
                selectedText = option3;
                break;
            default:
                selectedText = option4 + "\nThank you! Hope to see you again soon!";
        }
        System.out.println("You selected: " + selectedText);

        return selected;
    }

}