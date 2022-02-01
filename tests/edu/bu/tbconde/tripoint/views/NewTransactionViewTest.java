package edu.bu.tbconde.tripoint.views;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewTransactionViewTest {
    private NewTransactionView view;
    private String validSimulation1;
    private String validSimulation2;
    private String validCategory;
    private String validCategory2;
    private String validCategory3;
    private String validCategory4;
    private String invalidSimulation1;
    private double doubleSimulation;

    @BeforeEach
    void setUp() {
        view = new NewTransactionView();
        validSimulation1 = "BASIC";
        validSimulation2 = "PreFerreD";
        validCategory = "TRAVEL";
        validCategory2 = "Dining";
        validCategory3 = "Online SHOPPING";
        validCategory4 = "GroCeRy";
        invalidSimulation1 = "invalid";
        doubleSimulation = 5.5;
    }

    @AfterEach
    void tearDown() {
        view = null;
        validSimulation1 = null;
        validSimulation2 = null;
        invalidSimulation1 = null;
        validCategory = null;
        doubleSimulation = 0;
    }

    @Test
    void askCardType() {
        assertEquals("basic",view.askCardType(validSimulation1));
        assertEquals("preferred",view.askCardType(validSimulation2));
    }

    @Test
    void askCategory() {
        assertEquals("travel",view.askCategory(validCategory));
        assertEquals("dining",view.askCategory(validCategory2));
        assertEquals("online shopping",view.askCategory(validCategory3));
        assertEquals("grocery",view.askCategory(validCategory4));
    }

    @Test
    void askAmount() {
        assertEquals(5.5, view.askAmount(doubleSimulation));
    }
}