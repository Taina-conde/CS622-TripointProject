package edu.bu.tbconde.tripoint.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Callable;

public class InitializePreferencesThread implements Callable<ArrayList<UserPreferences<Preference>>> {
    private int userId;
    private ArrayList<UserPreferences<Preference>> userPrefsList;
    private PreferencesReader reader;
    private PreferencesWriter writer;
    public InitializePreferencesThread(int userId) {
        this.userId = userId;
        userPrefsList = new ArrayList<UserPreferences<Preference>>();
        reader = new PreferencesReader();
        writer = new PreferencesWriter();
    }
    public InitializePreferencesThread(int userId, String path) {
        this.userId = userId;
        userPrefsList = new ArrayList<UserPreferences<Preference>>();
        reader = new PreferencesReader(path);
        writer = new PreferencesWriter(path);
    }
    public ArrayList<UserPreferences<Preference>> call() throws ClassNotFoundException{
        try {
            userPrefsList = reader.readUserPreferences(userId);
        }
        catch (IOException ex) {
            try { writer.writePreferences(userPrefsList);}
            catch(IOException err) {
                err.printStackTrace();
            }
        }
        return userPrefsList;
    }
}
