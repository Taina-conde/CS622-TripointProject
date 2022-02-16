package edu.bu.tbconde.tripoint.controllers;

import edu.bu.tbconde.tripoint.util.RecordsWriter;
import edu.bu.tbconde.tripoint.views.CloseAccountView;

import java.io.IOException;

public class CloseAccountController {
    private CloseAccountView view;
    public CloseAccountController(){
        view = new CloseAccountView();
    }
    public boolean handleCloseAccount(RecordsWriter writer){
        boolean closeAccount;
        view.displayCloseMessage();
        closeAccount = view.askCloseAccount();
        if (closeAccount) {
            try {
                writer.deleteRecords();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return closeAccount;
    }
}
