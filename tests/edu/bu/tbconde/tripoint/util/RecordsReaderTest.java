package edu.bu.tbconde.tripoint.util;

import edu.bu.tbconde.tripoint.cards.BasicCard;
import edu.bu.tbconde.tripoint.cards.CreditCard;
import edu.bu.tbconde.tripoint.transactions.PurchaseTransaction;
import edu.bu.tbconde.tripoint.transactions.RedeemTransaction;
import edu.bu.tbconde.tripoint.transactions.Transaction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RecordsReaderTest {
    private RecordsReader reader = null;
    private RecordsWriter writer = null;
    private ArrayList<Transaction> expectedRecords = null;
    private ArrayList<Transaction> expectedPurchaseRecords = null;
    private ArrayList<Transaction> expectedRedeemRecords = null;
    private PurchaseTransaction trans1 = null;
    private PurchaseTransaction trans2 = null;
    private RedeemTransaction trans3 = null;
    private RedeemTransaction trans4 = null;
    private RedeemTransaction trans5 = null;
    private CreditCard card = null;

    @BeforeEach
    void setUp() {
        writer = new RecordsWriter("tests/edu/bu/tbconde/tripoint/io/testFile.dat");
        expectedRecords = new ArrayList<Transaction>();
        expectedPurchaseRecords = new ArrayList<Transaction>();
        expectedRedeemRecords = new ArrayList<Transaction>();
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
        expectedPurchaseRecords.add(trans1);
        expectedPurchaseRecords.add(trans2);
        expectedRedeemRecords.add(trans3);
        expectedRedeemRecords.add(trans4);
        expectedRedeemRecords.add(trans5);
        try {
            writer.writeRecords(expectedRecords);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    void tearDown() {
        reader = null;
        writer = null;
        expectedRecords = null;
        expectedRedeemRecords = null;
        expectedPurchaseRecords = null;
        card = null;
        trans1 = null;
        trans2 = null;
        trans3 = null;
        trans4 = null;
        trans5 = null;
    }

    @Test
    void readRecordsThrowsIOException() {
        reader = new RecordsReader("tests/edu/bu/tbconde/tripoint/io/wrongFile.dat");
        assertThrows(IOException.class, () -> reader.readRecords());
    }
    @Test
    void readRecordsThrowsClassNotFoundException() {
        String path = "tests/edu/bu/tbconde/tripoint/io/throwsTest.dat";
        //the file throwsTest.dat contains an obj that isn't in the test
        //when the reader tries to read the file, it throws a ClassNotFoundException
        reader = new RecordsReader("tests/edu/bu/tbconde/tripoint/io/throwsTest.dat");

        assertThrows(ClassNotFoundException.class, () -> reader.readRecords());
    }
    @Test
    void readRecords() throws IOException, ClassNotFoundException {
        reader = new RecordsReader("tests/edu/bu/tbconde/tripoint/io/testFile.dat");
        ArrayList<Transaction> actualRecords = reader.readRecords();
        int maxSize = Math.max(expectedRecords.size(), actualRecords.size());
        for (int i = 0; i < maxSize; i++) {
            assertEquals(expectedRecords.get(i).toString(), actualRecords.get(i).toString());
        }
    }
    @Test
    void readPurchaseRecords() throws IOException, ClassNotFoundException {
        reader = new RecordsReader("tests/edu/bu/tbconde/tripoint/io/testFile.dat");
        ArrayList<Transaction> actualRecords = reader.readPurchaseRecords();
        int maxSize = Math.max(expectedPurchaseRecords.size(), actualRecords.size());
        for (int i = 0; i < maxSize; i++) {
            assertEquals(expectedPurchaseRecords.get(i).toString(), actualRecords.get(i).toString());
        }
    }
    @Test
    void readRedeemRecords() throws IOException, ClassNotFoundException {
        reader = new RecordsReader("tests/edu/bu/tbconde/tripoint/io/testFile.dat");
        ArrayList<Transaction> actualRecords = reader.readRedeemRecords();
        int maxSize = Math.max(expectedRedeemRecords.size(), actualRecords.size());
        for (int i = 0; i < maxSize; i++) {
            assertEquals(expectedRedeemRecords.get(i).toString(), actualRecords.get(i).toString());
        }
    }

}