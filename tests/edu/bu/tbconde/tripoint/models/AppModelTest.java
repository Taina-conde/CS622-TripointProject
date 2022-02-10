package edu.bu.tbconde.tripoint.models;

import edu.bu.tbconde.tripoint.controllers.WelcomeController;
import edu.bu.tbconde.tripoint.transactions.Transaction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

class AppModelTest {
    private AppModel model = null;
    private ArrayList<Transaction> records = null;
    @BeforeEach
    void setUp() {
        model = new AppModel(2);
        records = new ArrayList<Transaction>();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void initializeRecords() throws ExecutionException, InterruptedException {
        int points = 0;
        records = model.initializeRecords();
        for (Transaction trans: records) {
            if (trans.getType().equals("redeem")) {
                points -= trans.getPoints();
            } else {
                points += trans.getPoints();
            }
        }
        assertTrue(model.getPointsBalance() == points);
    }
}