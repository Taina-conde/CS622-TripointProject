package app;

/**This class controls the view and model to support the points account*/
public class AppController {
    AppModel model = new AppModel();
    AppView view = new AppView();

    public AppController() {
        getUsername();
        printInitialMessage();
    }

    private void getUsername() {
        model.setCustomer(view.askUsername());
    }
    private void printInitialMessage() {
        System.out.println("Hello, " + model.getCustomer()+ "!");

    }
    public static void main(String[] args) {
        AppController controller = new AppController();


    }


}
