package edu.bu.tbconde.tripoint.controllers;

import edu.bu.tbconde.tripoint.models.PastTransactionsModel;
import edu.bu.tbconde.tripoint.util.RecordsReader;
import edu.bu.tbconde.tripoint.views.PastTransactionsView;

import java.util.ArrayList;

public class PastTransactionsController {
    private PastTransactionsModel model;
    private PastTransactionsView view ;
    private RecordsReader reader;
    public PastTransactionsController() {
        model = new PastTransactionsModel();
        view = new PastTransactionsView();
        reader = new RecordsReader();
    }

    public void displayPastTransactions() {
        int numberTrans = model.readAllRecords();
        if (numberTrans == 0) {
            System.out.println("You haven't made any transactions yet.");
        }
        else {
            view.printHeader();
            for (String line: model.getRecords()) {
                String[] tokens = line.split(", ");
                if (tokens.length == 4) {
                    model.setCardType(tokens[0].trim());
                    model.setCategory(tokens[1].trim());
                    model.setAmount(tokens[2].trim()) ;
                    model.setPoints(tokens[3].trim());
                    view.printRecord(
                            model.getCardType(),
                            model.getCategory(),
                            model.getAmount(),
                            model.getPoints()
                    );
                }
            }
        }
    }
}
