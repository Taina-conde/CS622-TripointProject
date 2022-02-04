package edu.bu.tbconde.tripoint.util;

import edu.bu.tbconde.tripoint.cards.BasicCard;
import edu.bu.tbconde.tripoint.cards.CreditCard;
import edu.bu.tbconde.tripoint.transactions.PurchaseTransaction;
import edu.bu.tbconde.tripoint.transactions.Transaction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class RecordsWriterTest {
    private RecordsWriter writer = null;
    private Transaction transaction = null;
    private CreditCard card = null;

    @BeforeEach
    void setUp() {
        writer = new RecordsWriter("tests/edu/bu/tbconde/tripoint/io/testWriter.dat");
        card = new BasicCard();
        transaction = new PurchaseTransaction(card, "dining", 70 );
    }

    @AfterEach
    void tearDown() {
        writer = null;
        transaction = null;
        card = null;
    }

    @Test
    void writeRecordThrowsIOException() {
        assertThrows(IOException.class, () -> writer.writeRecord(transaction, true));
    }
    @Test
    void writeRecord() throws IOException {
        assertTrue(writer.writeRecord(transaction, true));
    }

//    @Test
//    void deleteRecords() {
//        assertTrue(writer.deleteRecords());
//    }
}