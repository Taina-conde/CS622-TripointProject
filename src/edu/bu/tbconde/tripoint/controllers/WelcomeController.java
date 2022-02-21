package edu.bu.tbconde.tripoint.controllers;

import edu.bu.tbconde.tripoint.database.UseDataBase;
import edu.bu.tbconde.tripoint.util.User;
import edu.bu.tbconde.tripoint.views.WelcomeView;
import edu.bu.tbconde.tripoint.models.WelcomeModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class WelcomeController {
    private WelcomeView view;
    private WelcomeModel model;
    private UseDataBase db;
    public WelcomeController() {
        view = new WelcomeView();
        model = new WelcomeModel();
        db = new UseDataBase();

    }
    public WelcomeController(String username) {
        view = new WelcomeView();
        model = new WelcomeModel(username);
        db = new UseDataBase();
    }
    public User greetCustomer() {
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
    public User createAccount() throws SQLException{
        User user = null;
        String url = "jdbc:sqlite:src/edu/bu/tbconde/tripoint/database/User.db";
        model.setFirstName(view.askFirstName());
        model.setLastName(view.askLastName());
        model.setUsername(view.askUsername());
        model.setPassword(view.askPassword());
        try(Connection conn = DriverManager.getConnection(url)) {
            try {
                db.createNewUser(conn, model.getFirstName(), model.getLastName(), model.getUsername(), model.getPassword());
                view.greetUser(model.getFirstName(), model.getLastName());
                user = db.searchUser(conn, model.getUsername(), model.getPassword());
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return user;
    }
    public User login(){
        User user = null;
        String url = "jdbc:sqlite:src/edu/bu/tbconde/tripoint/database/User.db";
        String username = view.askUsername();
        String password = view.askPassword();
        try (Connection conn = DriverManager.getConnection(url)) {
            user = db.searchUser(conn,username, password);
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        //view.greetUser(model.getFirstName(), model.getLastName());
        return user;
    }
}
