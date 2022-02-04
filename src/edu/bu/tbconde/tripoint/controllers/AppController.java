package edu.bu.tbconde.tripoint.controllers;

import edu.bu.tbconde.tripoint.cards.BasicCard;
import edu.bu.tbconde.tripoint.cards.PreferredCard;
import edu.bu.tbconde.tripoint.models.AppModel;
import edu.bu.tbconde.tripoint.transactions.Transaction;
import edu.bu.tbconde.tripoint.util.RecordsReader;
import edu.bu.tbconde.tripoint.util.RecordsWriter;
import edu.bu.tbconde.tripoint.views.AppView;

import java.io.IOException;
import java.util.ArrayList;

public class AppController {
    private final int  walletCapacity = 2;
    private AppModel model = new AppModel(walletCapacity);
    private AppView view = new AppView();
    private RecordsWriter writer;
    private RecordsReader reader;
   private WelcomeController welcome= new WelcomeController();
   private NewTransactionController newTrans;
   private MainMenuController menu ;
   private PastTransactionsController pastTrans;

    private boolean exit = false;

    public AppController() {
        String customer = welcome.greetCustomer();
        model.addCard(new PreferredCard(customer));
        model.addCard(new BasicCard(customer));
        newTrans = new NewTransactionController(model.getWallet());
        writer = new RecordsWriter();
        reader = new RecordsReader();
        menu = new MainMenuController();
        pastTrans = new PastTransactionsController();
    }
    public boolean getExit() {return exit;}
    private void exitApp() {
        //remove all past transactions from transactionsRecord.txt
        //exit = writer.deleteRecords();
        exit = true;
        if (exit) {System.out.println("Thank you! Hope to see you again soon!");}


    }
    private void saveTransaction(Transaction transaction) {
        boolean isWritten = false;
        try {
            model.addTrans(transaction);
            model.addPoints(transaction.getPoints());
            isWritten = writer.writeRecords(model.getRecords());
        }
        catch(IOException err) {
            err.printStackTrace();
        }
        if (!isWritten) {
            System.out.println("Unable to complete your request. Please, try again.");
        }
    }
    public ArrayList<Transaction> readAllRecords() {
        try {
            model.setRecords(reader.readRecords());
        }
        catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return model.getRecords();
    }
    public void processMenuOption() {
        switch (menu.selectOption()) {
            case 1:
                Transaction trans = newTrans.processPurchaseTransaction();
                saveTransaction(trans);
                break;
            case 2:
                pastTrans.displayPastTransactions(readAllRecords());
                break;
            case 3:
                //TODO: redeem points
                trans = newTrans.processPurchaseTransaction();
                saveTransaction(trans);
                break;
            default:
                exitApp();
                break;
        }
    }

   public static void main(String[] args) {
        AppController controller = new AppController();
        while (!controller.getExit()) {
            controller.processMenuOption();
        }

   }
}
