package edu.bu.tbconde.tripoint.views;

import java.util.Locale;
import java.util.Scanner;

public class WelcomeView {
    private Scanner sc = new Scanner(System.in);;
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
    public String askFirstName(){
        String answer;
        System.out.println("First Name: ");
        answer = sc.nextLine().trim().replaceAll("\\p{P}", "").toLowerCase();;
        String firstName = answer.substring(0,1).toUpperCase() + answer.substring(1);
        return firstName;
    }
    public String askLastName(){
        String answer;
        System.out.println("Last Name: ");
        answer = sc.nextLine().trim().replaceAll("\\p{P}", "").toLowerCase();;
        String lastName = answer.substring(0,1).toUpperCase() + answer.substring(1);
        return lastName;

    }
    public String askUsername() {
        String answer;
        System.out.println("Username: ");
        answer = sc.nextLine().trim();;
        return answer;
    }
    public String askPassword() {
        String answer;
        System.out.println("Password: ");
        answer = sc.nextLine().trim();
        return answer;
    }



}
