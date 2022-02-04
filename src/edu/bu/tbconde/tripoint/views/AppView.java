package edu.bu.tbconde.tripoint.views;

public class AppView {
    public void printRedeemFail( int pointsBalance)  {
        System.out.println("\nYou don't have enough points to process this transaction.\n" +
                "You have " + pointsBalance + " points.\n"
        );
    }
}
