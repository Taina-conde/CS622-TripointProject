package edu.bu.tbconde.tripoint.app;

import edu.bu.tbconde.tripoint.cards.PreferredCard;
import edu.bu.tbconde.tripoint.cards.BasicCard;
import edu.bu.tbconde.tripoint.util.RecordsWriter;

/**This class controls the view and model to support the points account*/
public class AppController {
    private RecordsWriter writer = new RecordsWriter();
    private AppModel model = new AppModel(2);
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
        System.out.printf("You have %,d points.\n", model.getPointsBalance());
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
                exitApp();
                break;
        }

    }
    private void processTransaction() {
        //collect user input about a new transaction card type, category and amount
        System.out.println("You made a new purchase. \n");
        String cardType = view.askCardType();
        System.out.println(
                "Next, please enter the category of te purchase (dining, travel, online shopping, or grocery)"
        );
        String category = view.askCategory();
        System.out.println("Finally, enter the amount purchased");
        double amount = view.askAmount();
        //set the current transaction in the model using the information the user entered
        model.setCurrentTrans(cardType, category, amount);
        int points = model.getCurrentTrans().calculatePoints();
        model.saveTransaction();
        int catValue = model.getCurrentTrans().getCard().getCategoryValue(category);
        System.out.println();
        System.out.println("Processing new transaction ...");
        System.out.println();
        view.displayTransaction(cardType, category, amount, catValue, points);

    }

    private void printPastTransactions() {
        view.displayTransactionRecords();
    }

    private void exitApp() {
        //remove all past transactions from transactionsRecord.txt
        this.exit = writer.writeRecord("", false);
        if (this.exit) {System.out.println("Thank you! Hope to see you again soon!");}
    }

    public static void main(String[] args) {
        AppController controller = new AppController();

        while(!controller.getExit()) {
            controller.showMainMenu();
        }
        //TODO: implement option 3 redeem points of main menu





    }


}
