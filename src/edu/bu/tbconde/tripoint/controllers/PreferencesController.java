package edu.bu.tbconde.tripoint.controllers;

import edu.bu.tbconde.tripoint.views.PreferencesView;

public class PreferencesController {
    private PreferencesView view;
    public PreferencesController() {
        view = new PreferencesView();
    }
    public void handlePreferences() {
        int selected = view.preferencesMenu();
        if (selected == 1) {
            loadSavedPreferences();
        } else {
            setNewPreference();
        }
    }
    private void loadSavedPreferences() {

    }
    private void setNewPreference() {

    }
}
