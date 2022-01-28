package edu.bu.tbconde.tripoint.views;

import java.util.Scanner;

public class WelcomeView {
    private Scanner sc = new Scanner(System.in);;
    public String askUsername() {
        sc = new Scanner(System.in);
        System.out.print("Username: ");
        return sc.nextLine();
    }

}
