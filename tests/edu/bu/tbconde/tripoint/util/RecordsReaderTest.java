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
    private PurchaseTransaction trans1 = null;
    private PurchaseTransaction trans2 = null;
    private CreditCard card = null;

    public class TestObj implements Serializable {
        private int att;
        public TestObj() {
            att = 5;
        }
    }

    @BeforeEach
    void setUp() {
        writer = new RecordsWriter("tests/edu/bu/tbconde/tripoint/io/testFile.dat");
        expectedRecords = new ArrayList<Transaction>();
        card = new BasicCard();
        trans1 = new PurchaseTransaction(card, "dining", 70);
        trans2 = new PurchaseTransaction(card, "travel", 500);
        expectedRecords.add(trans1);
        expectedRecords.add(trans2);
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
        card = null;
        trans1 = null;
        trans2 = null;
    }

    @Test
    void readRecordsThrowsIOException() {
        reader = new RecordsReader("tests/edu/bu/tbconde/tripoint/io/wrongFile.dat");
        assertThrows(IOException.class, () -> reader.readRecords());
    }
    @Test
    void readRecordsThrowsClassNotFoundException() {
        String path = "tests/edu/bu/tbconde/tripoint/io/throwsTest.dat";
        //create a serializable obj that isn't the obj that RecordsReader expects to read
        TestObj test = new TestObj();
        ArrayList<TestObj> testList = new ArrayList<>();
        // write that obj to throwsTest.dat file
        try (ObjectOutputStream outfile = new ObjectOutputStream(new FileOutputStream(path))) {

            outfile.writeObject(testList);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Test if reader throws ClassNotFoundException when reading the throwsTest.dat file
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

}