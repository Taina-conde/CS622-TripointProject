package edu.bu.tbconde.tripoint.controllers;

import edu.bu.tbconde.tripoint.views.CloseAccountView;

public class CloseAccountController {
    private CloseAccountView view;
    public CloseAccountController(){
        view = new CloseAccountView();
    }
    public boolean handleCloseAccount(){
        view.displayCloseMessage();
    }
}
