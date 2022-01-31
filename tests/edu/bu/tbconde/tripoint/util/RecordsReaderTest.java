package edu.bu.tbconde.tripoint.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecordsReaderTest {
    private RecordsReader reader = null;
    @BeforeEach
    void setUp() {
        reader = new RecordsReader();
    }

    @AfterEach
    void tearDown() {
        reader = null;
    }

    @Test
    void printAllRecords() {

    }
}