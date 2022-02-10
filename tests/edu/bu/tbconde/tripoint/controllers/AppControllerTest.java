package edu.bu.tbconde.tripoint.controllers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppControllerTest {
    private AppController controller = null;

    @BeforeEach
    void setUp() {
        controller = new AppController();
    }

    @AfterEach
    void tearDown() {
        controller = null;
    }

    @Test
    void exitApp() {
        //assertTrue(controller.exitApp());
    }

    @Test
    void saveTransaction() {
    }

    @Test
    void readAllRecords() {
    }

    @Test
    void readPurchaseRecords() {
    }

    @Test
    void readRedeemRecords() {
    }

    @Test
    void handleInitializeRecords() {
    }
}