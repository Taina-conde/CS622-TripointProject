package edu.bu.tbconde.tripoint.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecordsWriterTest {
    private RecordsWriter writer = null;
    @BeforeEach
    void setUp() {
        writer = new RecordsWriter("tests/edu/bu/tbconde/tripoint/io/testWriter.txt");
    }

    @AfterEach
    void tearDown() {
        writer = null;
    }

    @Test
    void writeRecord() {
    }

    @Test
    void testWriteRecord() {
    }
}