package edu.bu.tbconde.tripoint.controllers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WelcomeControllerTest {
    private WelcomeController welcome = null;

    @BeforeEach
    void setUp() {
        welcome = new WelcomeController();
    }

    @AfterEach
    void tearDown() {
        welcome = null;
    }

    @Test
    void greetCustomer() {

    }
}