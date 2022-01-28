package edu.bu.tbconde.tripoint.controllers;

import edu.bu.tbconde.tripoint.views.WelcomeView;
import edu.bu.tbconde.tripoint.models.WelcomeModel;

public class WelcomeController {
    private WelcomeView view = new WelcomeView();
    private WelcomeModel model = new WelcomeModel();
    public void greetCustomer() {
        model.setUsername(view.askUsername());
        System.out.println("Hello, " + model.getUsername()+ "!");
    }
}
