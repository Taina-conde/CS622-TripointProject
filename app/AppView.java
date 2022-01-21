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
}
