package edu.bu.tbconde.tripoint.views;

import java.util.Scanner;

public class CloseAccountView {
    private Scanner sc = new Scanner(System.in);
    public void displayCloseMessage(){
        System.out.println("If you close your account, your points balance will be set to 0 and all " +
                "your past transactions will be deleted. \n");
    }
    public boolean askCloseAccount() {
        String answer;
        System.out.println("Are you sure you want to close your account?\n");
        System.out.println("Please, enter \"y\" if you want to close your account, or \"n\" if you want to return to the main menu.");
        answer = sc.nextLine().trim().replaceAll("\\p{P}", "").toLowerCase();
        while(!(answer.equals("y") || answer.equals("n"))) {
            System.out.println(answer + " is not a valid answer.\n" +
                    "Please, enter \"y\" if you want to close your account, or \"n\" if you want to return to the main menu.");
            answer = sc.nextLine().trim().replaceAll("\\p{P}", "").toLowerCase();
        }
        if (answer.equals("y")) {
            return true;
        }
        return false;
    }
    public void successMessage() {
        System.out.println("\nYou successfully closed your account...\n" +
                "\nYou now have 0 points and your records have been reset.");

    }
}
