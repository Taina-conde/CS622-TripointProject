package edu.bu.tbconde.tripoint.controllers;

import edu.bu.tbconde.tripoint.config.*;
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
    public UserPreferences handlePreferences(int userId, ArrayList<UserPreferences<Preference>> userPrefsList) {
        UserPreferences selectedPrefs;
        int selected = view.preferencesMenu(model.getMenuOption1(), model.getMenuOption2());
        if (selected == 1) {
            selectedPrefs = loadSavedPreferences(userId, userPrefsList);
            if (selectedPrefs == null) {
                boolean setNew = view.askSetNewPreference();
                if (setNew) {
                    return setNewPreference(userId, userPrefsList);
                }
            }
            return selectedPrefs;

        }
        return setNewPreference(userId, userPrefsList);
    }
    private UserPreferences loadSavedPreferences(int userId, ArrayList<UserPreferences<Preference>> userPrefsList) {
        UserPreferences selectedPrefs;
        if (userPrefsList.size() == 0) {
            return null;
        }
        selectedPrefs = view.askSavedPreferences(userPrefsList);
        return selectedPrefs;
    }
    private UserPreferences setNewPreference(int userId, ArrayList<UserPreferences<Preference>> userPrefsList) {
        CurrencyPreference currPref = new CurrencyPreference(userId, view.askCurrency(
                model.getCurrencyOption1(),
                model.getCurrencyOption2()
        ));
        OrderByPreference orderPref = new OrderByPreference(userId, view.askOrderBy(
                model.getOrderOption1(),
                model.getOrderOption2(),
                model.getOrderOption3(),
                model.getOrderOption4(),
                model.getOrderOption5()
        ));
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
