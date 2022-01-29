package edu.bu.tbconde.tripoint.controllers;

import edu.bu.tbconde.tripoint.models.PastTransactionsModel;
import edu.bu.tbconde.tripoint.views.PastTransactionsView;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PastTransactionsController {
    private PastTransactionsModel model = new PastTransactionsModel();
    private PastTransactionsView view = new PastTransactionsView();
    public void displayPastTransactions() {
        view.printAllRecords();

    }
}
