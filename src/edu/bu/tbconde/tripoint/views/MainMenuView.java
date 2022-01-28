package edu.bu.tbconde.tripoint.views;

import java.util.Scanner;

public class MainMenuView {
    private Scanner sc = new Scanner(System.in);
    public int displayOptions(String option1, String option2, String option3, String option4) {
        int selected;
        String selectedText;
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
                selectedText = option4;
        }
        System.out.println("You selected: " + selectedText);
        return selected;
    }
}
