package edu.bu.tbconde.tripoint.transactions;

import edu.bu.tbconde.tripoint.cards.BasicCard;
import edu.bu.tbconde.tripoint.cards.PreferredCard;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTransactionTest {

    private CategoryTransaction transaction = null;
    private PreferredCard preferred = null;
    private BasicCard basic = null;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        transaction = new CategoryTransaction();
        preferred = new PreferredCard();
        basic = new BasicCard();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        transaction = null;
        preferred = null;
        basic = null;
    }

    @org.junit.jupiter.api.Test
    void testCalculatePoints() {
        //assertEquals();
    }
}