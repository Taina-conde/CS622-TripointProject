package edu.bu.tbconde.tripoint.cards;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicCardTest {
    private BasicCard basic = null;

    @BeforeEach
    void setUp() {
        basic = new BasicCard();
    }

    @AfterEach
    void tearDown() {
        basic = null;
    }

    @Test
    void getTravelValue() {
        assertTrue(basic.getCategoryValue("travel") == 5);
    }
    @Test
    void getDiningValue() {
        assertTrue(basic.getCategoryValue("dining") == 3);
    }
    @Test
    void getOnlineShopValue() {
        assertTrue(basic.getCategoryValue("onlineShop") == 10);
    }
    @Test
    void getGroceryValue() {
        assertTrue(basic.getCategoryValue("grocery") == 8);
    }

}