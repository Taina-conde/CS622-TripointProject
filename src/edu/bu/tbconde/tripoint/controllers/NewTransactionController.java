package edu.bu.tbconde.tripoint.controllers;

import edu.bu.tbconde.tripoint.util.Wallet;
import edu.bu.tbconde.tripoint.cards.CreditCard;
import edu.bu.tbconde.tripoint.models.NewTransactionModel;
import edu.bu.tbconde.tripoint.util.RecordsWriter;
import edu.bu.tbconde.tripoint.views.NewTransactionView;

public class NewTransactionController {
    private NewTransactionModel model;
    private NewTransactionView view;
    private RecordsWriter writer;
    public NewTransactionController(Wallet<CreditCard> wallet) {
        model = new NewTransactionModel(wallet);
        view = new NewTransactionView();
        writer = new RecordsWriter();
    }
    private void collectPurchaseInfo() {
        System.out.println("You made a new purchase. \n");
        model.setCardType(view.askCardType());
        System.out.println(
                "Next, please enter the category of te purchase (dining, travel, online shopping, or grocery)"
        );
        model.setCategory(view.askCategory());
        System.out.println("Finally, enter the amount purchased");
        model.setAmount(view.askAmount());
    }

    private void collectRedeemInfo() {
        System.out.println("Redeem points for travel.\n");
        System.out.println("Enter the price of the item you want to pay for using your points");
        model.setAmount(view.askAmount());
    }
    private void saveTransaction() {
        boolean isWritten;
        String transaction = String.format("%s, %s, %.2f, %,d",
                model.getCardType(),
                model.getCategory(),
                model.getAmount(),
                model.getPoints()
        );
        isWritten = writer.writeRecord(transaction, true);
        if (!isWritten) {
            System.out.println("Unable to complete your request. Please, try again.");
        }
    }
    public int processNewTransaction() {
        collectPurchaseInfo();
        model.createNewTransaction();
        view.displayTransaction(
                model.getCardType(),
                model.getCategory(),
                model.getAmount(),
                model.getCatValue(),
                model.getPoints()
        );
        saveTransaction();
        return model.getPoints();
    }

}
