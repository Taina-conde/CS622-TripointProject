package edu.bu.tbconde.myproject.app;

import edu.bu.tbconde.myproject.cards.PreferredCard;
import edu.bu.tbconde.myproject.cards.BasicCard;

/**This class controls the view and model to support the points account*/
public class AppController {
    AppModel model = new AppModel();
    AppView view = new AppView();

    public AppController() {
        getUsername();
        printInitialMessage();

        model.addCard(new PreferredCard(model.getCustomer()));
        model.addCard(new BasicCard(model.getCustomer()));
    }

    private void getUsername() {
        model.setCustomer(view.askUsername());
    }
    private void printInitialMessage() {
        System.out.println("Hello, " + model.getCustomer()+ "!");

    }
    private void processTransaction() {
        //for now hard code a new transaction - suppose the user entered "basic, travel, 55.6"
        model.setCurrentTrans("basic", "travel", 55.6);
        int points = model.getCurrentTrans().calculatePoints();
        model.saveTransaction();
        int catValue = model.getCurrentTrans().getCard().getCategoryValue("travel");
        System.out.println();
        System.out.println("Processing new transaction ...");
        System.out.println();
        view.displayTransaction("basic", "travel", 55.6, catValue, points);

    }
    /*private void info() {
        CreditCard card1 = model.getCardsList().get(0);
        CreditCard card2 = model.getCardsList().get(1);
        System.out.println(card1.getType());
        System.out.println(card2.getType());

    }*/
    private void printPastTransactions() {
        view.displayTransactionRecords();
    }
    public static void main(String[] args) {
        AppController controller = new AppController();
        //TODO : initial menu with options ( view past transactions, make new transaction, view points balance, view points value per card)
        // if user makes new transaction
        controller.processTransaction();
        // if user chooses to view past transactions
        controller.printPastTransactions();





    }


}
