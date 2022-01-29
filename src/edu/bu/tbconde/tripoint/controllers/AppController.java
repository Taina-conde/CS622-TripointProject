package edu.bu.tbconde.tripoint.controllers;

import edu.bu.tbconde.tripoint.cards.BasicCard;
import edu.bu.tbconde.tripoint.cards.PreferredCard;
import edu.bu.tbconde.tripoint.models.AppModel;
import edu.bu.tbconde.tripoint.util.RecordsWriter;
import edu.bu.tbconde.tripoint.views.AppView;

public class AppController {
    private final int  walletCapacity = 2;
    private AppModel model = new AppModel(walletCapacity);
    private RecordsWriter writer = new RecordsWriter();
    private AppView view = new AppView();
   private WelcomeController welcome = new WelcomeController();
   private NewTransactionController newTrans;
   private MainMenuController menu = new MainMenuController();
   private PastTransactionsController pastTrans = new PastTransactionsController();

    private boolean exit = false;

    public AppController() {
        String customer = welcome.greetCustomer();
        model.addCard(new PreferredCard(customer));
        model.addCard(new BasicCard(customer));
        newTrans = new NewTransactionController(model.getWallet());

    }
    public boolean getExit() {return exit;}
    private void exitApp() {
        //remove all past transactions from transactionsRecord.txt
        exit = writer.writeRecord("", false);
        if (exit == true) {System.out.println("Thank you! Hope to see you again soon!");}


    }
    public void processMenuOption() {
        switch (menu.selectOption()) {
            case 1:
                newTrans.processNewTransaction();
                
                break;
            case 2:
                pastTrans.displayPastTransactions();
                break;
            case 3:
                //TODO: redeem points
                System.out.println("to be implemented");
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
