package edu.bu.tbconde.tripoint.util;

import edu.bu.tbconde.tripoint.cards.BasicCard;
import edu.bu.tbconde.tripoint.cards.CreditCard;
import edu.bu.tbconde.tripoint.transactions.PurchaseTransaction;
import edu.bu.tbconde.tripoint.transactions.Transaction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RecordsReaderTest {
    private RecordsReader reader = null;
    private ArrayList<Transaction> expectedRecords = null;
    private PurchaseTransaction trans1 = null;
    private PurchaseTransaction trans2 = null;
    private CreditCard card = null;
    @BeforeEach
    void setUp() {
        reader = new RecordsReader("tests/edu/bu/tbconde/tripoint/io/testFile.dat");
        expectedRecords = new ArrayList<Transaction>();
        card = new BasicCard();
        trans1 = new PurchaseTransaction(card, "dining", 70);
        trans2 = new PurchaseTransaction(card, "travel", 500);
        expectedRecords.add(trans1);
        expectedRecords.add(trans2);
    }

    @AfterEach
    void tearDown() {
        reader = null;
        expectedRecords = null;
        card = null;
        trans1 = null;
        trans2 = null;
    }

    @Test
    void readRecordsThrowsIOException() {
        assertThrows(IOException.class, () -> reader.readRecords());
    }
//    @Test
//    void readRecordsThrowsClassNotFoundException() {
//        assertThrows(ClassNotFoundException.class, () -> reader.readRecords());
//    }
    @Test
    void readRecords() throws IOException, ClassNotFoundException {
        ArrayList<Transaction> actualRecords = reader.readRecords();
        int maxSize = Math.max(expectedRecords.size(), actualRecords.size());
        for (int i = 0; i < maxSize; i++) {
            assertEquals(expectedRecords.get(i).toString(), actualRecords.get(i).toString());
        }
    }

}