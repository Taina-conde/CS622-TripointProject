package edu.bu.tbconde.tripoint.views;

import java.util.Scanner;

public class WelcomeView {
    private Scanner sc = new Scanner(System.in);;
    public String askUsername() {
        sc = new Scanner(System.in);
        System.out.print("Username: ");
        return sc.nextLine();
    }
    public boolean welcomeMessage() {
        String answer;
        System.out.println("Welcome to Tripoint - A Point System for Credit Cards");
        System.out.println("Do you have an account?");
        System.out.println("Please, enter \"y\" if you want to login, or \"n\" if you want to create an account.");
        answer = sc.nextLine().trim().replaceAll("\\p{P}", "").toLowerCase();
        while(!(answer.equals("y")||answer.equals("n"))) {
            System.out.println(answer + " is not a valid answer.\n" +
                    "Please, enter \"y\" if you want to login, or \"n\" if you want to create an account.");
            answer = sc.nextLine().trim().replaceAll("\\p{P}", "").toLowerCase();
        }
        if (answer.equals("y")) {
            return true;
        }
        return false;
    }

}
