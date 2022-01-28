package edu.bu.tbconde.tripoint.controllers;

import edu.bu.tbconde.tripoint.models.MainMenuModel;
import edu.bu.tbconde.tripoint.views.MainMenuView;

public class MainMenuController {
    private MainMenuView view = new MainMenuView();
    private MainMenuModel model = new MainMenuModel();

    public void showMenu() {
        model.setSelectedOption(
                view.displayOptions(
                        model.getOption1(),
                        model.getOption2(),
                        model.getOption3(),
                        model.getOption4()
                )
        );
    }
//    public void processOption() {
//        switch (model.getSelectedOption()) {
//            case 1:
//                processTransaction();
//                break;
//            case 2:
//                printPastTransactions();
//                break;
//            case 3:
//                //TODO: redeem points
//                System.out.println("to be implemented");
//                break;
//            default:
//                exitApp();
//                break;
//        }
//    }
}
