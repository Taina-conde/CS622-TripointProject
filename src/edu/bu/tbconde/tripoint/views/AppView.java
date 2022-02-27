package edu.bu.tbconde.tripoint.views;

import edu.bu.tbconde.tripoint.config.Preference;
import edu.bu.tbconde.tripoint.config.UserPreferences;

public class AppView {
    public void printRedeemFail( int pointsBalance)  {
        System.out.println("\nYou don't have enough points to process this transaction.\n" +
                "You have " + pointsBalance + " points.\n"
        );
    }
    public void printRedeemMessage(int pointsBalance) {
        System.out.printf("You have %,d points to redeem \n"  +
                        "Every $1 is equivalent to 2 points.\n",
                pointsBalance);
    }
    public void checkBalance(int pointsBalance) {
        System.out.printf("You have %,d points \n", pointsBalance);
    }
    public void printPreferencesMessage(UserPreferences<Preference> userPrefs) {
        System.out.printf(
                "\nYour past transactions will be in %s and ordered by %s\n",
                userPrefs.get(0),
                userPrefs.get(1)
        );
    }

}
