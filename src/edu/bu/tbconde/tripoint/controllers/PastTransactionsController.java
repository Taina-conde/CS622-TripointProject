package edu.bu.tbconde.tripoint.controllers;

import edu.bu.tbconde.tripoint.models.PastTransactionsModel;
import edu.bu.tbconde.tripoint.views.PastTransactionsView;
import edu.bu.tbconde.tripoint.transactions.Transaction;

import java.util.ArrayList;


public class PastTransactionsController {
    private PastTransactionsModel model;
    private PastTransactionsView view ;

    public PastTransactionsController() {
        model = new PastTransactionsModel();
        view = new PastTransactionsView();
    }
    public int handleMenu() {
        model.setSelectedOption(view.askMenu(
                model.getOption1(),
                model.getOption2(),
                model.getOption3()
        ));
        return model.getSelectedOption();
    }

    public int displayPastTransactions(ArrayList<Transaction> records, int pointsBalance) {
        if (records.size() == 0) {
            System.out.println("You haven't made any transactions yet.");
        }
        else {
            view.printHeader(pointsBalance);

        }
        return pointsBalance;
    }
}
