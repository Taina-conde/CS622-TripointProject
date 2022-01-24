package edu.bu.tbconde.tripoint.cards;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PreferredCardTest {
    private PreferredCard preferred = null;

    @BeforeEach
    void setUp() {
        preferred = new PreferredCard();
    }

    @AfterEach
    void tearDown() {
        preferred = null;
    }

    @Test
    void getTravelValue() {
        assertTrue(preferred.getCategoryValue("travel") == 10);
    }
    @Test
    void getDiningValue() {
        assertTrue(preferred.getCategoryValue("dining") == 8);
    }
    @Test
    void getOnlineShopValue() {
        assertTrue(preferred.getCategoryValue("onlineShop") == 5);
    }
    @Test
    void getGroceryValue() {
        assertTrue(preferred.getCategoryValue("grocery") == 3);
    }

}