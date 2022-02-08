package edu.bu.tbconde.tripoint.util;

import edu.bu.tbconde.tripoint.cards.BasicCard;
import edu.bu.tbconde.tripoint.cards.CreditCard;
import edu.bu.tbconde.tripoint.transactions.PurchaseTransaction;
import edu.bu.tbconde.tripoint.transactions.RedeemTransaction;
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
    private Transaction transaction3 = null;
    private Transaction transaction4 = null;
    private Transaction transaction5 = null;
    private CreditCard card = null;
    ArrayList<Transaction> records = null;
    public static final String OSTYPE = System.getProperty("os.name").toLowerCase();

    @BeforeEach
    void setUp() {
        card = new BasicCard();
        transaction = new PurchaseTransaction(card, "dining", 70);
        transaction2 = new PurchaseTransaction(card, "travel", 500);
        transaction3 = new RedeemTransaction(10);
        transaction4 = new RedeemTransaction(20);
        transaction5 = new RedeemTransaction(30);
        records = new ArrayList<Transaction>();
        records.add(transaction);
        records.add(transaction2);
        records.add(transaction3);
        records.add(transaction4);
        records.add(transaction5);
    }
    @AfterEach
    void tearDown() {
        writer = null;
        transaction = null;
        transaction2 = null;
        transaction3 = null;
        transaction4 = null;
        transaction5 = null;
        card = null;
        records = null;
    }
    @Test
    void writeRecordsThrowsIOException() {
        String path = OSTYPE.contains("win") ? "\\\\////" : "/var/log";
        writer = new RecordsWriter(path);
        assertThrows(IOException.class, () -> writer.writeRecords(records));
    }
    @Test
    void writeRecord() throws IOException {
        writer = new RecordsWriter("tests/edu/bu/tbconde/tripoint/io/testFile.dat");
        assertTrue(writer.writeRecords(records));
    }

}