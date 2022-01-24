package edu.bu.tbconde.tripoint.transactions;

import edu.bu.tbconde.tripoint.cards.BasicCard;
import edu.bu.tbconde.tripoint.cards.PreferredCard;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTransactionTest {
    private double amount = 0;
    private CategoryTransaction transaction = null;
    private PreferredCard preferred = null;
    private BasicCard basic = null;

    @BeforeEach
    void setUp() {
        amount = 55.6;
        preferred = new PreferredCard();
        basic = new BasicCard();
    }

    @AfterEach
    void tearDown() {
        amount = 0;
        preferred = null;
        basic = null;
        transaction = null;
    }

    @Test
    void testCalculatePointsBasicTravel() {

        transaction = new CategoryTransaction(basic, "travel", amount);
        assertEquals(transaction.calculatePoints(), 278);
    }
    @Test
    void testCalculatePointsBasicDining() {

        transaction = new CategoryTransaction(basic, "dining", amount);
        assertEquals(transaction.calculatePoints(), 166);
    }
    @Test
    void testCalculatePointsBasicOnlineShop() {

        transaction = new CategoryTransaction(basic, "onlineShop", amount);
        assertEquals(transaction.calculatePoints(), 556);
    }
    @Test
    void testCalculatePointsBasicGrocery() {

        transaction = new CategoryTransaction(basic, "grocery", amount);
        assertEquals(transaction.calculatePoints(), 444);
    }

    @Test
    void testCalculatePointsPreferredTravel() {

        transaction = new CategoryTransaction(preferred, "travel", amount);
        assertEquals(transaction.calculatePoints(), 556);
    }
    @Test
    void testCalculatePointsPreferredDining() {

        transaction = new CategoryTransaction(preferred, "dining", amount);
        assertEquals(transaction.calculatePoints(), 444);
    }
    @Test
    void testCalculatePointsPreferredOnlineShop() {

        transaction = new CategoryTransaction(preferred, "onlineShop", amount);
        assertEquals(transaction.calculatePoints(), 278);
    }
    @Test
    void testCalculatePointsPreferredGrocery() {

        transaction = new CategoryTransaction(preferred, "grocery", amount);
        assertEquals(transaction.calculatePoints(), 166);
    }
}