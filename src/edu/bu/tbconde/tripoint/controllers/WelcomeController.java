package edu.bu.tbconde.tripoint.controllers;

import edu.bu.tbconde.tripoint.views.WelcomeView;
import edu.bu.tbconde.tripoint.models.WelcomeModel;

public class WelcomeController {
    private WelcomeView view = new WelcomeView();
    private WelcomeModel model = new WelcomeModel();
    public WelcomeController() {
        model.setUsername(view.askUsername());
    }
    public String greetCustomer() {
        System.out.println("Hello, " + model.getUsername()+ "!");
        return model.getUsername();
    }
}
