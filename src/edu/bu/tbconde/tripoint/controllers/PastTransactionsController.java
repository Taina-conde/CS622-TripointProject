package edu.bu.tbconde.tripoint.controllers;

import edu.bu.tbconde.tripoint.models.PastTransactionsModel;
import edu.bu.tbconde.tripoint.views.PastTransactionsView;
import edu.bu.tbconde.tripoint.transactions.Transaction;


public class PastTransactionsController {
    private PastTransactionsModel model;
    private PastTransactionsView view ;

    public PastTransactionsController() {
        model = new PastTransactionsModel();
        view = new PastTransactionsView();
    }

    public void displayPastTransactions() {
        int numberTrans = model.readAllRecords();
        if (numberTrans == 0) {
            System.out.println("You haven't made any transactions yet.");
        }
        else {
            view.printHeader();
            for (Transaction trans: model.getRecords()) {
                view.printRecord(trans);
            }
        }
    }
}
