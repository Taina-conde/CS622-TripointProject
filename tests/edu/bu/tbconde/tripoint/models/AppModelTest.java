package edu.bu.tbconde.tripoint.models;

import edu.bu.tbconde.tripoint.controllers.WelcomeController;
import edu.bu.tbconde.tripoint.transactions.Transaction;
import edu.bu.tbconde.tripoint.util.InitializeRecordsThread;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import static org.junit.jupiter.api.Assertions.*;

class AppModelTest {
    private AppModel model = null;
    private ArrayList<Transaction> records = null;
    @BeforeEach
    void setUp() {
        records = new ArrayList<Transaction>();
    }
    @AfterEach
    void tearDown() {
        records = null;
    }

 //   @Test
//    void initializeRecords() throws ExecutionException, InterruptedException {
//        model = new AppModel(2);
//        int points = 0;
//        records = model.initializeRecords();
//        for (Transaction trans: records) {
//            if (trans.getType().equals("redeem")) {
//                points -= trans.getPoints();
//            } else {
//                points += trans.getPoints();
//            }
//        }
//        assertTrue(model.getPointsBalance() == points);
//    }
//    @Test
//    void initializeRecordThrowsExecutionException() {
//        /*ExecutionException wraps whatever exception the thread being executed threw, so if your thread was,
//        for instance, doing some kind of IO that caused an IOException to get thrown, that would get wrapped
//        in an ExecutionException and rethrown.
//        In the test below, the file throwsTest.dat contains an obj that isn't in the test, so
//        when the reader (inside initializeRecords() method) tries to read the file, it throws a ClassNotFoundException.
//        This exception gets wrapped in an ExecutionException and rethrown.
//        Source: https://stackoverflow.com/questions/2665569/in-what-cases-does-future-get-throw-executionexception-or-interruptedexception
//        */
//        String path = "tests/edu/bu/tbconde/tripoint/io/throwsTest.dat";
//        model = new AppModel(2, path );
//        assertThrows(ExecutionException.class, () -> model.initializeRecords());
//    }
}