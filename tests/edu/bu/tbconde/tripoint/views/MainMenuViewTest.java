package edu.bu.tbconde.tripoint.views;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MainMenuViewTest {
    private MainMenuView menu = null;
    private final String option1 = "1.Register a new purchase \n ";
    private final String option2 = "2.View past transactions \n ";
    private final String option3 = "3.Redeem points \n ";
    private final String option4 = "4.Exit \n";
    private Scanner sc = null;

    @BeforeEach
    void setUp() {
        menu = new MainMenuView();
        sc = new Scanner(System.in);

    }

    @AfterEach
    void tearDown() {
        menu = null;
        sc = null;
    }

    @Test
    void displayOptions() {
        int userChoice = menu.displayOptions(option1, option2, option3, option4);

    }
}