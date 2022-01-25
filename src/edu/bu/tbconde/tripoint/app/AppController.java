package edu.bu.tbconde.tripoint.app;

import edu.bu.tbconde.tripoint.cards.PreferredCard;
import edu.bu.tbconde.tripoint.cards.BasicCard;
import edu.bu.tbconde.tripoint.exceptions.IncorrectFileNameException;

/**This class controls the view and model to support the points account*/
public class AppController {
    AppModel model = new AppModel();
    AppView view = new AppView();
    boolean exit = false;

    public AppController() {
        setUsername();
        printInitialMessage();
        model.addCard(new PreferredCard(model.getCustomer()));
        model.addCard(new BasicCard(model.getCustomer()));
    }
    public boolean getExit() {return exit;}

    private void setUsername() {
        model.setCustomer(view.askUsername());
    }
    private void printInitialMessage() {
        System.out.println("Hello, " + model.getCustomer()+ "!");
        System.out.printf("You have %,d points.\n", model.getPointsBalance());
    }
    private void showMainMenu() {
        int selected = view.askMainMenu();
        switch (selected) {
            case 1:
                processTransaction();
                break;
            case 2:
                printPastTransactions();
                break;
            case 3:
                //TODO: redeem points
                System.out.println("to be implemented");
                break;
            default:
                this.exit = true;
                break;
        }

    }
    private void processTransaction() {
        //for now hard code a new transaction - suppose the user entered "basic, travel, 55.6"
        model.setCurrentTrans("basic", "travel", 55.6);
        int points = model.getCurrentTrans().calculatePoints();
        try {
            /*All the following code is in the try block because I don't want it to print the messages and display
            * the transaction if the fileName where the transaction was supposed to be saved to is incorrect*/
            model.saveTransaction();
            int catValue = model.getCurrentTrans().getCard().getCategoryValue("travel");
            System.out.println();
            System.out.println("Processing new transaction ...");
            System.out.println();
            view.displayTransaction("basic", "travel", 55.6, catValue, points);
        }
        catch(IncorrectFileNameException e) {
            e.printStackTrace();
        }
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

        while(!controller.getExit()) {
            controller.showMainMenu();
        }

//        //TODO : initial menu with options ( view past transactions, make new transaction, view points balance, view points value per card)
//        // if user makes new transaction
//        controller.processTransaction();
//        // if user chooses to view past transactions
//        controller.printPastTransactions();





    }


}
