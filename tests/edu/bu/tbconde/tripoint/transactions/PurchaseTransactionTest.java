package edu.bu.tbconde.tripoint.transactions;

import edu.bu.tbconde.tripoint.cards.BasicCard;
import edu.bu.tbconde.tripoint.cards.PreferredCard;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseTransactionTest {
    private double amount = 0;
    private PurchaseTransaction transaction = null;
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

        transaction = new PurchaseTransaction(basic, "travel", amount);
        assertEquals( 278, transaction.calculatePoints());
    }
    @Test
    void testCalculatePointsBasicDining() {

        transaction = new PurchaseTransaction(basic, "dining", amount);
        assertEquals(166, transaction.calculatePoints());
    }
    @Test
    void testCalculatePointsBasicOnlineShop() {

        transaction = new PurchaseTransaction(basic, "onlineShop", amount);
        assertEquals(556, transaction.calculatePoints());
    }
    @Test
    void testCalculatePointsBasicGrocery() {

        transaction = new PurchaseTransaction(basic, "grocery", amount);
        assertEquals(444, transaction.calculatePoints());
    }

    @Test
    void testCalculatePointsPreferredTravel() {

        transaction = new PurchaseTransaction(preferred, "travel", amount);
        assertEquals(556, transaction.calculatePoints());
    }
    @Test
    void testCalculatePointsPreferredDining() {

        transaction = new PurchaseTransaction(preferred, "dining", amount);
        assertEquals(444, transaction.calculatePoints());
    }
    @Test
    void testCalculatePointsPreferredOnlineShop() {

        transaction = new PurchaseTransaction(preferred, "onlineShop", amount);
        assertEquals(278, transaction.calculatePoints());
    }
    @Test
    void testCalculatePointsPreferredGrocery() {

        transaction = new PurchaseTransaction(preferred, "grocery", amount);
        assertEquals(166, transaction.calculatePoints());
    }
}