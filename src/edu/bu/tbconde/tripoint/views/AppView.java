package edu.bu.tbconde.tripoint.views;

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

}
