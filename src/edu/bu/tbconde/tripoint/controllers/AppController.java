package edu.bu.tbconde.tripoint.controllers;

import edu.bu.tbconde.tripoint.cards.BasicCard;
import edu.bu.tbconde.tripoint.cards.PreferredCard;
import edu.bu.tbconde.tripoint.database.UseDataBase;
import edu.bu.tbconde.tripoint.models.AppModel;
import edu.bu.tbconde.tripoint.transactions.Transaction;
import edu.bu.tbconde.tripoint.util.RecordsReader;
import edu.bu.tbconde.tripoint.util.RecordsWriter;
import edu.bu.tbconde.tripoint.util.User;
import edu.bu.tbconde.tripoint.views.AppView;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class AppController {
    private String url = "jdbc:sqlite:src/edu/bu/tbconde/tripoint/database/Database.db";
    private UseDataBase db = new UseDataBase();
    private final int  walletCapacity = 2;
    private AppModel model = new AppModel(walletCapacity);
    private AppView view = new AppView();
    private RecordsWriter writer;
    private RecordsReader reader;
   private WelcomeController welcome= new WelcomeController();
   private NewTransactionController newTrans;
   private MainMenuController menu ;
   private PastTransactionsController pastTrans;
   private CloseAccountController closeAccount;
   private boolean isInitialized;
    private boolean exit = false;

    public AppController() {
        welcomeUser();
        model.addCard(new PreferredCard(model.getUser().getUsername()));
        model.addCard(new BasicCard(model.getUser().getUsername()));
        newTrans = new NewTransactionController(model.getWallet());
        writer = new RecordsWriter();
        reader = new RecordsReader();
        menu = new MainMenuController();
        pastTrans = new PastTransactionsController();
        closeAccount = new CloseAccountController();
        isInitialized = false;
    }
    public void welcomeUser(){
        User user = welcome.greetCustomer();
        if (user != null) {
            model.setUser(user);
        } else {
            exitApp();
        }
    }
    public boolean getExit() {return exit;}
    public boolean exitApp() {
        exit = true;
        if (exit) {System.out.println("Thank you! Hope to see you again soon!");}
        return exit;

    }
    public Transaction saveTransaction(Transaction transaction) {
        Transaction trans = null;
        try (Connection conn = DriverManager.getConnection(url)) {
            model.addTrans(transaction);
            if(transaction.getType() == "purchase") {
                model.addPoints(transaction.getPoints());
            } else {
                model.removePoints(transaction.getPoints());
            }
            db.insertTrans(conn, transaction, model.getUser().getId());
            trans = transaction;

        }
        catch(SQLException err) {
            err.printStackTrace();
        }
        return trans;
    }

    public boolean handleInitializeRecords() {
        try {
            model.initializeRecords();
            isInitialized = true;
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return isInitialized;
    }

    public void handlePastTransactions() {
        int selected = pastTrans.handleMenu();
        String typeSearched;
        int userId = model.getUser().getId();
        try (Connection conn = DriverManager.getConnection(url)) {
            if (selected == 1) {
                typeSearched = "purchase";
                db.searchRecordsByType(conn, userId, typeSearched );
            } else if (selected == 2) {
                typeSearched = "redeem";
                db.searchRecordsByType(conn, userId, typeSearched );
            } else {
                db.searchUserTransactions(conn, userId );
            }
        }
        catch(SQLException err) {
            err.printStackTrace();
        }
    }
    public void handleCloseAccount() {
        boolean closed;
        closed = closeAccount.handleCloseAccount(writer);
        if (closed) {
            model.setPointsBalance(0);
        }

    }
    public Integer handleCheckBalance() {
        try (Connection conn = DriverManager.getConnection(url)) {
            return db.calculatePointsBalance(conn, model.getUser().getId());
        }
        catch(SQLException err) {
            err.printStackTrace();
        }
        return null;
    }

    public void processMenuOption() {
        int pointsBalance = handleCheckBalance();
        if (!isInitialized) {
            handleInitializeRecords();
        }
        Transaction trans;
        switch (menu.selectOption()) {
            case 1:
                trans = newTrans.processPurchaseTransaction();
                saveTransaction(trans);
                break;
            case 2:
                handlePastTransactions();
                break;
            case 3:
                view.printRedeemMessage(pointsBalance);
                trans = newTrans.processRedeemTransaction(pointsBalance);
                if (trans == null) {
                    view.printRedeemFail(pointsBalance);
                } else {
                    saveTransaction(trans);
                }
                break;
            case 4:
                view.checkBalance(pointsBalance);
                break;
            case 5:
                handleCloseAccount();
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
