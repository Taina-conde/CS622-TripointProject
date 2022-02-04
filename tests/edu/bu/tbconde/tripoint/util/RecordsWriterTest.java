package edu.bu.tbconde.tripoint.util;

import edu.bu.tbconde.tripoint.cards.BasicCard;
import edu.bu.tbconde.tripoint.cards.CreditCard;
import edu.bu.tbconde.tripoint.transactions.PurchaseTransaction;
import edu.bu.tbconde.tripoint.transactions.Transaction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RecordsWriterTest {
    private RecordsWriter writer = null;
    private Transaction transaction = null;
    private Transaction transaction2 = null;
    private CreditCard card = null;
    ArrayList<Transaction> records = null;

    @BeforeEach
    void setUp() {
        writer = new RecordsWriter("tests/edu/bu/tbconde/tripoint/io/testWriter.dat");
        card = new BasicCard();
        transaction = new PurchaseTransaction(card, "dining", 70);
        transaction2 = new PurchaseTransaction(card, "travel", 500);
        records = new ArrayList<Transaction>();
        records.add(transaction);
        records.add(transaction2);
    }
    @AfterEach
    void tearDown() {
        writer = null;
        transaction = null;
        transaction2 = null;
        card = null;
        records = null;
    }

    @Test
    void writeRecordsThrowsIOException() {
        assertThrows(IOException.class, () -> writer.writeRecords(records));
    }
    @Test
    void writeRecord() throws IOException {
        assertTrue(writer.writeRecords(records));
    }

//    @Test
//    void deleteRecords() {
//        assertTrue(writer.deleteRecords());
//    }
}