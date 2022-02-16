package edu.bu.tbconde.tripoint.views;

import java.util.Scanner;

public class CloseAccountView {
    private Scanner sc = new Scanner(System.in);
    public void displayCloseMessage(){
        System.out.println("If you close your account, your points balance will be set to 0 and all" +
                "your past transactions will be deleted. ");
    }
    public void askCloseAccount() {

    }
}
