package edu.bu.tbconde.tripoint.controllers;

import edu.bu.tbconde.tripoint.transactions.Transaction;
import edu.bu.tbconde.tripoint.util.Wallet;
import edu.bu.tbconde.tripoint.cards.CreditCard;
import edu.bu.tbconde.tripoint.models.NewTransactionModel;
import edu.bu.tbconde.tripoint.views.NewTransactionView;


public class NewTransactionController {
    private NewTransactionModel model;
    private NewTransactionView view;

    public NewTransactionController(Wallet<CreditCard> wallet) {
        model = new NewTransactionModel(wallet);
        view = new NewTransactionView();
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
        System.out.println("You want to redeem points.\n");
        System.out.println("Please, enter the price of the item you want to pay for using your points");
        model.setAmount(view.askAmount());
    }
    public Transaction processPurchaseTransaction() {
        collectPurchaseInfo();
        Transaction trans = model.createPurchaseTransaction();
        view.displayTransaction(trans);
        return model.getCurrTrans();
    }
    public Transaction processRedeemTransaction(int pointsBalance) {
        collectRedeemInfo();
        Transaction trans = model.createRedeemTransaction();
        if(model.getCurrTrans().getPoints() < pointsBalance) {
            view.displayTransaction(trans);
            return model.getCurrTrans();
        }
        return null;

    }

}
