package edu.bu.tbconde.tripoint.controllers;

import edu.bu.tbconde.tripoint.models.PastTransactionsModel;
import edu.bu.tbconde.tripoint.views.PastTransactionsView;

public class PastTransactionsController {
    private PastTransactionsModel model = new PastTransactionsModel();
    private PastTransactionsView view = new PastTransactionsView();
    public void displayPastTransactions() {
        int numberTrans = model.readAllRecords();
        if ( numberTrans > 0){
            view.printHeader();
            for (int i = 0; i <= numberTrans; i++) {
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
