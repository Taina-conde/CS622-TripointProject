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
    private CreditCard card1;
    private CreditCard card2;
    private int capacity = 0;
    @BeforeEach
    void setUp() {
        capacity = 2;
        wallet = new Wallet<CreditCard>(capacity);
        card1 = new BasicCard();
        card2 = new PreferredCard();
    }

    @AfterEach
    void tearDown() {
        capacity = 0;
        wallet = null;
    }

    @Test
    void get() {
        int index = 0;
        wallet.add(card1);
        assertEquals(card1, wallet.get(index));
    }
    @Test
    void getNull() {
        int index = 1;
        wallet.add(card1);
        /* we added one element to the wallet with capacity for 2 cards
        if we try to get the second element, we should expect null,
        since there is no second element in this particular wallet.*/
        assertNull( wallet.get(index));
    }

    @Test
    void add() {
        assertEquals(card1, wallet.add(card1));
    }

    @Test
    void size() {
        wallet.add(card1);
        assertEquals(1, wallet.size());
        wallet.add(card2);
        assertEquals(2, wallet.size());
    }
}