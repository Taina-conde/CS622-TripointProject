package edu.bu.tbconde.tripoint.controllers;

import edu.bu.tbconde.tripoint.database.UseDataBase;
import edu.bu.tbconde.tripoint.views.WelcomeView;
import edu.bu.tbconde.tripoint.models.WelcomeModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class WelcomeController {
    private WelcomeView view;
    private WelcomeModel model;
    public WelcomeController() {
        view = new WelcomeView();
        model = new WelcomeModel();

    }
    public WelcomeController(String username) {
        view = new WelcomeView();
        model = new WelcomeModel(username);
    }
    public String greetCustomer() {
        boolean hasAccount;
        hasAccount = view.initialMessage();
        if (hasAccount) {
            return login();
        } else {
            try {
                return createAccount();
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
    public String createAccount() throws SQLException{
        UseDataBase db = new UseDataBase();
        String url = "jdbc:sqlite:src/edu/bu/tbconde/tripoint/database/User.db";
        model.setFirstName(view.askFirstName());
        model.setLastName(view.askLastName());
        model.setUsername(view.askUsername());
        model.setPassword(view.askPassword());
        try(Connection conn = DriverManager.getConnection(url)) {
            try {
                db.createNewUser(conn, model.getFirstName(), model.getLastName(), model.getUsername(), model.getPassword());
                view.greetUser(model.getFirstName(), model.getLastName());
                return model.getFirstName() + model.getLastName();
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
    public String login(){
        String username = view.askUsername();
        view.greetUser(model.getFirstName(), model.getLastName());
        return username;


    }
}
