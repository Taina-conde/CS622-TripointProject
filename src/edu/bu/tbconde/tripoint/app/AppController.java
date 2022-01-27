package edu.bu.tbconde.tripoint.app;

import edu.bu.tbconde.tripoint.cards.PreferredCard;
import edu.bu.tbconde.tripoint.cards.BasicCard;

/**This class controls the view and model to support the points account*/
public class AppController {
    private AppModel model = new AppModel();
    private AppView view = new AppView();
    private boolean exit = false;

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
        //TODO: collect user input to create a new transaction
        //String cardType = view.askTransactionInfo();
        //String category = view.askTransactionInfo();
        //double amount = view.askTransactionInfo();
        //for now hard code a new transaction - suppose the user entered "basic, travel, 55.6"
        model.setCurrentTrans("basic", "travel", 55.6);
        int points = model.getCurrentTrans().calculatePoints();

            model.saveTransaction();
            int catValue = model.getCurrentTrans().getCard().getCategoryValue("travel");
            System.out.println("Processing new transaction ...");
            System.out.println();
            view.displayTransaction("basic", "travel", 55.6, catValue, points);

    }

    private void printPastTransactions() {
        view.displayTransactionRecords();
    }
    public static void main(String[] args) {
        AppController controller = new AppController();

        while(!controller.getExit()) {
            controller.showMainMenu();
        }
        //TODO: implement option 3 redeem points of main menu





    }


}
