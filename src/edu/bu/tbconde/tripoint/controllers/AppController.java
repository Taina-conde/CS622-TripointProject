package edu.bu.tbconde.tripoint.controllers;

import edu.bu.tbconde.tripoint.models.AppModel;
import edu.bu.tbconde.tripoint.views.AppView;

public class AppController {
   private WelcomeController welcome = new WelcomeController();
   private MainMenuController menu = new MainMenuController();
    private AppModel model = new AppModel();
    private AppView view = new AppView();
    private boolean exit = false;

   public static void main(String[] args) {


   }
}
