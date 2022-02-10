package edu.bu.tbconde.tripoint.util;

import edu.bu.tbconde.tripoint.cards.BasicCard;
import edu.bu.tbconde.tripoint.cards.CreditCard;
import edu.bu.tbconde.tripoint.transactions.PurchaseTransaction;
import edu.bu.tbconde.tripoint.transactions.RedeemTransaction;
import edu.bu.tbconde.tripoint.transactions.Transaction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import static org.junit.jupiter.api.Assertions.*;

class InitializeRecordsThreadTest {
    private final String path = "tests/edu/bu/tbconde/tripoint/io/testFile.dat";
    private FutureTask<ArrayList<Transaction>> future = null;
    private Thread initThread = null;
    private ArrayList<Transaction> expectedRecords = null;
    private PurchaseTransaction trans1 = null;
    private PurchaseTransaction trans2 = null;
    private RedeemTransaction trans3 = null;
    private RedeemTransaction trans4 = null;
    private RedeemTransaction trans5 = null;
    private CreditCard card;
    @BeforeEach
    void setUp() {
        card = new BasicCard();
        expectedRecords = new ArrayList<Transaction>();
        card = new BasicCard();
        trans1 = new PurchaseTransaction(card, "dining", 70);
        trans2 = new PurchaseTransaction(card, "travel", 500);
        trans3 = new RedeemTransaction(10);
        trans4 = new RedeemTransaction(20);
        trans5 = new RedeemTransaction(30);
        expectedRecords.add(trans1);
        expectedRecords.add(trans2);
        expectedRecords.add(trans3);
        expectedRecords.add(trans4);
        expectedRecords.add(trans5);
        future = new FutureTask<ArrayList<Transaction>>(new InitializeRecordsThread(path));
        initThread = new Thread(future);
        initThread.start();
    }

    @AfterEach
    void tearDown() {
        future = null;
        initThread = null;
        expectedRecords = null;
        card = null;
        trans1 = null;
        trans2 = null;
        trans3 = null;
        trans4 = null;
        trans5 = null;
    }

    @Test
    void call() throws ExecutionException, InterruptedException {
        ArrayList<Transaction> actualRecords = future.get();
        int maxSize = Math.max(expectedRecords.size(), actualRecords.size());
        for (int i = 0; i < maxSize; i++) {
            assertEquals(expectedRecords.get(i).toString(), actualRecords.get(i).toString());
        }
    }
}