package edu.bu.tbconde.tripoint.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainMenu {
    private Scanner sc;
    public MainMenu(){
        sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    }
    public int askMenuOptions() {
        String option1 = "1.Register a new purchase \n ";
        String option2 = "2.View past transactions \n ";
        String option3 = "3.Redeem points \n";
        String selectedText;
        int selected;
        System.out.println("What would you like to do?\n " +
              option1 + option2 + option3);
        do {
            System.out.println("Please, enter 1, 2, or 3.");
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
