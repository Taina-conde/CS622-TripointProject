package app;

import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.BufferedReader;

/**This class handles input and output on the user interface related to his points account*/
public class AppView {
    public String askUsername() {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        System.out.print("Username: ");
        //TODO: validate user input
        return sc.next();
    }
    public void displayTransaction(String cardType, String category, double amount, int categoryValue, int points) {
        System.out.println(
                "You spent $" + amount + " on " + category + " using your " + cardType + " card.\n" +
                        "The " + cardType + " card gives you "+ categoryValue +
                        " points for every $1 spent on " +  category + ". \n" +
                        "You earned " + points + " points in this transaction. \n");
    }


}
