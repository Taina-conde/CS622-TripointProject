package edu.bu.tbconde.tripoint.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecordsWriterTest {
    private RecordsWriter writer = null;
    private String transactionTest = null;
    private String empty = null;
    @BeforeEach
    void setUp() {
        writer = new RecordsWriter("tests/edu/bu/tbconde/tripoint/io/testWriter.txt");
        transactionTest = "grocery, basic, 100";
        empty = "";
    }

    @AfterEach
    void tearDown() {
        writer = null;
        transactionTest = null;
        empty = null;
    }

    @Test
    void writeRecord() {
        assertTrue(writer.writeRecord(transactionTest, true));
    }

    @Test
    void deleteRecords() {
        assertTrue(writer.deleteRecords());
    }
}