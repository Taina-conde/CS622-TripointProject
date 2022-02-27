package edu.bu.tbconde.tripoint.controllers;

import edu.bu.tbconde.tripoint.config.PreferencesReader;
import edu.bu.tbconde.tripoint.config.PreferencesWriter;
import edu.bu.tbconde.tripoint.config.UserPreferences;
import edu.bu.tbconde.tripoint.models.PreferencesModel;
import edu.bu.tbconde.tripoint.views.PreferencesView;

import java.io.IOException;
import java.util.ArrayList;

public class PreferencesController {
    private PreferencesView view;
    private PreferencesModel model;
    private PreferencesReader reader;
    private PreferencesWriter writer;
    public PreferencesController() {
        view = new PreferencesView();
        model = new PreferencesModel();
        reader = new PreferencesReader();
        writer = new PreferencesWriter();
    }
    public void handlePreferences(int userId) {
        int selected = view.preferencesMenu();
        if (selected == 1) {
            loadSavedPreferences(userId);
        } else {
            setNewPreference(userId);
        }
    }
    private void loadSavedPreferences(int userId) {
        ArrayList<UserPreferences> userPrefs;
        try{
           userPrefs = reader.readUserPreferences(userId);
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        

    }
    private void setNewPreference() {

    }
}
