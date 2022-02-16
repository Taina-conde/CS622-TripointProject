package edu.bu.tbconde.tripoint.controllers;

import edu.bu.tbconde.tripoint.models.MainMenuModel;
import edu.bu.tbconde.tripoint.views.MainMenuView;

public class MainMenuController {
    private MainMenuView view = new MainMenuView();
    private MainMenuModel model = new MainMenuModel();
    private void showMenu() {
        model.setSelectedOption(
                view.displayOptions(
                        model.getOption1(),
                        model.getOption2(),
                        model.getOption3(),
                        model.getOption4(),
                        model.getOption5(),
                        model.getOption6()
                )
        );

    }
    public int selectOption(){
        showMenu();
        return model.getSelectedOption();
    }
}
