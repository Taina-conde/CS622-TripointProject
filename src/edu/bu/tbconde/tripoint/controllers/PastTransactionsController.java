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

    public void displayPastTransactions(ArrayList<Transaction> records) {
        if (records.size() == 0) {
            System.out.println("You haven't made any transactions yet.");
        }
        else {
            view.printHeader();
            for (Transaction trans: records) {
                view.printRecord(trans);
            }
        }
    }
}
