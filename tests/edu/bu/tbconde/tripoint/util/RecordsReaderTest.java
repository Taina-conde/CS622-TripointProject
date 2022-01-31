package edu.bu.tbconde.tripoint.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RecordsReaderTest {
    private RecordsReader reader = null;
    private ArrayList<String> lines = null;
    @BeforeEach
    void setUp() {
        reader = new RecordsReader("tests/edu/bu/tbconde/tripoint/io/testFile.txt");
        lines = new ArrayList<>();
        lines.add("I hope, my grade, will be over, 90");
        lines.add("I should, work hard, for it, then");
    }

    @AfterEach
    void tearDown() {
        reader = null;
    }

    @Test
    void readLines() {
        //first line
        assertEquals(lines.get(0), reader.readLines().get(0));
        //second line
        assertEquals(lines.get(1), reader.readLines().get(1));
    }
}