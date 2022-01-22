package app;

import cards.BasicCard;
import cards.CreditCard;
import cards.PreferredCard;
import transactions.CategoryTransaction;
import transactions.Transaction;

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
        model.addTransaction(model.getCurrentTrans());
        model.addPoints(points);
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
    public static void main(String[] args) {
        AppController controller = new AppController();
        //TODO : initial menu with options ( view past transactions, make new transaction, view points balance, view points value per card)
        controller.processTransaction();




    }


}
