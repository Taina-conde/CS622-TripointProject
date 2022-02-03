package edu.bu.tbconde.tripoint.controllers;

import edu.bu.tbconde.tripoint.models.WelcomeModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WelcomeControllerTest {
    private WelcomeController welcome = null;


    @BeforeEach
    void setUp() {
        welcome = new WelcomeController("tbconde");
    }

    @AfterEach
    void tearDown() {
        welcome = null;
    }

    @Test
    void greetCustomer() {
        assertEquals("tbconde", welcome.greetCustomer());
    }
}