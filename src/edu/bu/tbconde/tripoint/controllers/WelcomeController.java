package edu.bu.tbconde.tripoint.controllers;

import edu.bu.tbconde.tripoint.views.WelcomeView;
import edu.bu.tbconde.tripoint.models.WelcomeModel;

public class WelcomeController {
    private WelcomeView view;
    private WelcomeModel model;
    public WelcomeController() {
        view = new WelcomeView();
        model = new WelcomeModel();
        model.setUsername(view.askUsername());

    }
    public WelcomeController(String username) {
        view = new WelcomeView();
        model = new WelcomeModel(username);
    }
    public void greetCustomer() {
        boolean hasAccount;
        System.out.println("Welcome to Tripoint - A Point System for Credit Card");
        hasAccount = view.welcomeMessage();
        if (hasAccount) {
            login();
        } else {
            createAccount();
        }
    }
    public void createAccount() {

    }
    public void login(){

    }
}
