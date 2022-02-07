package edu.bu.tbconde.tripoint.transactions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RedeemTransactionTest {
    private double amount = 0;
    private RedeemTransaction transaction = null;
    @BeforeEach
    void setUp() {
        amount = 50;
        transaction = new RedeemTransaction(50);
    }

    @AfterEach
    void tearDown() {
        amount = 0;
        transaction = null;
    }

    @Test
    void calculatePoints() {
        assertEquals(100, transaction.calculatePoints());
    }
}