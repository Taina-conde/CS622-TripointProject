package edu.bu.tbconde.tripoint.util;

import edu.bu.tbconde.tripoint.cards.BasicCard;
import edu.bu.tbconde.tripoint.cards.CreditCard;
import edu.bu.tbconde.tripoint.cards.PreferredCard;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WalletTest {
    private Wallet<CreditCard> wallet = null;
    private CreditCard basic;
    private CreditCard preferred;
    private int capacity = 0;
    @BeforeEach
    void setUp() {
        capacity = 2;
        wallet = new Wallet<>(capacity);
        basic = new BasicCard();
        preferred = new PreferredCard();
    }

    @AfterEach
    void tearDown() {
        capacity = 0;
        wallet = null;
    }

    @Test
    void get() {
        int index = 1;
        wallet.add(basic);
        assertEquals(wallet.get(index), basic );


    }

    @Test
    void add() {
        assertEquals(wallet.add(basic), basic);
    }

    @Test
    void size() {
    }
}