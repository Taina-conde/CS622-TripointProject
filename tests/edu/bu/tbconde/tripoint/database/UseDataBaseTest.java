package edu.bu.tbconde.tripoint.database;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UseDataBaseTest {
    private UseDataBase db = null;
    @BeforeEach
    void setUp() {
        db = new UseDataBase();
    }

    @AfterEach
    void tearDown() {
        db = null;
    }

    @Test
    void createNewUser() {
    }

    @Test
    void searchUser() {
    }

    @Test
    void insertTrans() {
    }

    @Test
    void searchUserTransactions() {
    }

    @Test
    void searchRecordsByType() {
    }

    @Test
    void calculatePointsBalance() {
    }
}