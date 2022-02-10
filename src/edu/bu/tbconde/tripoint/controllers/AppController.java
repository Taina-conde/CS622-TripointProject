package edu.bu.tbconde.tripoint.controllers;

import edu.bu.tbconde.tripoint.cards.BasicCard;
import edu.bu.tbconde.tripoint.cards.PreferredCard;
import edu.bu.tbconde.tripoint.models.AppModel;
import edu.bu.tbconde.tripoint.transactions.Transaction;
import edu.bu.tbconde.tripoint.util.InitializeRecordsThread;
import edu.bu.tbconde.tripoint.util.RecordsReader;
import edu.bu.tbconde.tripoint.util.RecordsWriter;
import edu.bu.tbconde.tripoint.views.AppView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class AppController {
    private final int  walletCapacity = 2;
    private FutureTask<ArrayList<Transaction>> future = new FutureTask<ArrayList<Transaction>>(new InitializeRecordsThread());
    private Thread initThread;
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
        //start thread that will check that reads the file to get the arraylist of transactions
        initThread = new Thread(future);
        initThread.start();
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
    private boolean saveTransaction(Transaction transaction) {
        boolean isWritten = false;
        try {
            model.addTrans(transaction);
            if(transaction.getType() == "purchase") {
                model.addPoints(transaction.getPoints());
            } else {
                model.removePoints(transaction.getPoints());
            }
            isWritten = writer.writeRecords(model.getRecords());
        }
        catch(IOException err) {
            err.printStackTrace();
        }
        if (!isWritten) {
            System.out.println("Unable to complete your request. Please, try again.");
        }
        return isWritten;
    }
    
    private ArrayList<Transaction> initializeRecords() {
        try {
            model.setRecords(future.get());
            for (Transaction trans: model.getRecords()) {
                if (trans.getType().equals("redeem")) {
                    model.removePoints(trans.getPoints());
                } else {
                    model.addPoints(trans.getPoints());
                }
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return model.getRecords();
    }

    private ArrayList<Transaction> readAllRecords() {
        try {
            model.setRecords(reader.readRecords());
        }
        catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return model.getRecords();
    }

    private ArrayList<Transaction> readPurchaseRecords() {
        try {
            model.setPurchaseRecords(reader.readPurchaseRecords());
        }
        catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return model.getPurchaseRecords();
    }

    private ArrayList<Transaction> readRedeemRecords() {
        try {
            model.setRedeemRecords(reader.readRedeemRecords());
        }
        catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return model.getRedeemRecords();
    }

    private void handlePastTransactions() {
        int selected = pastTrans.handleMenu();
        if (selected == 1) {
            pastTrans.displayPastTransactions(readPurchaseRecords(), model.getPointsBalance());
        } else if (selected == 2) {
            pastTrans.displayPastTransactions(readRedeemRecords(), model.getPointsBalance());
        } else {
            pastTrans.displayPastTransactions(readAllRecords(), model.getPointsBalance());
        }
    }

    public void processMenuOption() {
        Transaction trans;
        switch (menu.selectOption()) {
            case 1:
                trans = newTrans.processPurchaseTransaction();
                saveTransaction(trans);
                break;
            case 2:
                initializeRecords();
                handlePastTransactions();
                break;
            case 3:
                view.printRedeemMessage(model.getPointsBalance());
                trans = newTrans.processRedeemTransaction(model.getPointsBalance());
                if (trans == null) {
                    view.printRedeemFail(model.getPointsBalance());
                } else {
                    saveTransaction(trans);
                }
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
