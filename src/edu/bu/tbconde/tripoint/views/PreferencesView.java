package edu.bu.tbconde.tripoint.views;

import edu.bu.tbconde.tripoint.config.Preference;
import edu.bu.tbconde.tripoint.config.UserPreferences;

import java.util.ArrayList;
import java.util.Scanner;

public class PreferencesView {
    private Scanner sc = new Scanner(System.in);

    public int preferencesMenu(String option1, String option2) {
        int selected;
        System.out.println("What would you like to do?\n " + option1 + option2);
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

    public String askCurrency(String currencyOption1, String currencyOption2) {
        int selected;
        System.out.println("\nSet currency:\n " + currencyOption1 + currencyOption2);
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
    public String askOrderBy(String option1, String option2, String option3, String option4, String option5) {
        int selected;
        System.out.println("\nOrder past transactions by: \n " + option1 + option2 + option3 + option4 + option5);
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
    public UserPreferences askSavedPreferences(ArrayList<UserPreferences<Preference>> userPrefsList) {
        int selected;
        int numPrefs = userPrefsList.size();
        System.out.println("Choose a previously saved preference: ");
        for (int i = 0; i < numPrefs; i++) {
            System.out.printf(" %d. %-30s \n", i + 1, userPrefsList.get(i));
        }
        do {
            if (numPrefs == 1) {
                System.out.printf("\nPlease, enter 1.\n");
            } else {
                System.out.printf("\nPlease, enter a number between 1 and %d.\n", numPrefs);
            }
            while(!sc.hasNextInt()) {
                System.out.println("Please, enter only numbers.");
                sc.nextLine();
            }
            selected = sc.nextInt();

        } while (!(selected >=1 && selected <= numPrefs));
        return userPrefsList.get(selected-1);
    }
    public boolean askSetNewPreference() {
        String answer;
        System.out.println("You don't have any preferences saved yet... Would you like to set a new preference?");
        System.out.println("Please, enter \"y\" if you want to set a new preference, or \"n\" to return to the main menu.");
        answer = sc.nextLine().trim().replaceAll("\\p{P}", "").toLowerCase();
        while(!(answer.equals("y")||answer.equals("n"))) {
            System.out.println(answer + " is not a valid answer.\n" +
                    "Please, enter \"y\" if you want to set a new preference, or \"n\" to return to the main menu.");
            answer = sc.nextLine().trim().replaceAll("\\p{P}", "").toLowerCase();
        }
        if (answer.equals("y")) {
            return true;
        }
        return false;
    }
}
