package edu.bu.tbconde.tripoint.controllers;

import edu.bu.tbconde.tripoint.config.*;
import edu.bu.tbconde.tripoint.models.PreferencesModel;
import edu.bu.tbconde.tripoint.views.PreferencesView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Currency;

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
    public UserPreferences handlePreferences(int userId, ArrayList<UserPreferences> userPrefsList) {
        UserPreferences selectedPrefs;
        int selected = view.preferencesMenu();
        if (selected == 1) {
            selectedPrefs = loadSavedPreferences(userId);
            if (selectedPrefs == null) {
                boolean setNew = view.askSetNewPreference();
                if (setNew) {
                    return setNewPreference(userId, userPrefsList);
                }
            }
        }
        return setNewPreference(userId, userPrefsList);
    }
    private UserPreferences loadSavedPreferences(int userId) {
        ArrayList<UserPreferences> userPrefsList;
        UserPreferences selectedPrefs;
        try{
           userPrefsList = reader.readUserPreferences(userId);
           if (userPrefsList.size() == 0) {
               return null;
           }
           selectedPrefs = view.askSavedPreferences(userPrefsList);
           return selectedPrefs;
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    private UserPreferences setNewPreference(int userId, ArrayList<UserPreferences> userPrefsList) {
        CurrencyPreference currPref = new CurrencyPreference(userId, view.askCurrency());
        OrderByPreference orderPref = new OrderByPreference(userId, view.askOrderBy());
        UserPreferences userPrefs = new UserPreferences( currPref, orderPref);
        userPrefsList.add(userPrefs);
        try {
            writer.writePreferences(userPrefsList);
            return userPrefs;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
