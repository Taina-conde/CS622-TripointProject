package edu.bu.tbconde.tripoint.views;

import java.util.Scanner;

public class WelcomeView {
    private String
    private Scanner sc = new Scanner(System.in);;
    public String askUsername() {
        sc = new Scanner(System.in);
        System.out.print("Username: ");
        return sc.nextLine();
    }
    private void printInitialMessage() {
        System.out.println("Hello, " + model.getCustomer()+ "!");
        System.out.printf("You have %,d points.\n", model.getPointsBalance());
    }
}
