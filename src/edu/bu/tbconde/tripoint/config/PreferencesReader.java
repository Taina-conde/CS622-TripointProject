package edu.bu.tbconde.tripoint.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.stream.Stream;

/**This class reads the preferences file*/
public class PreferencesReader {
    private ArrayList<UserPreferences> prefs;
    private String path = "src/edu/bu/tbconde/tripoint/config/preferences.dat";
    public PreferencesReader() {
        prefs = new ArrayList<UserPreferences>();
    }
    public PreferencesReader(String path) {
        this();
        this.path = path;
    }
    private ArrayList<UserPreferences> readAllUsersPreferences() throws IOException, ClassNotFoundException {
        /*The try-with-resources ensures that the resource is closed at the end of the statement. A resource is object
        that must be closed after the program is finished with it. In this case, ObjectInputStream is a resource that
        implements the AutoCloseable interface, and, therefore, it is automatically closed when exiting a
        try-with-resources statement.
        sources:
        https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
        https://docs.oracle.com/javase/8/docs/api/java/lang/AutoCloseable.html
        */
        try (ObjectInputStream infile = new ObjectInputStream(new FileInputStream(path))) {
            prefs = (ArrayList<UserPreferences>) infile.readObject();
        }
        return prefs;
    }
    public ArrayList<UserPreferences> readUserPreferences(int userId) throws IOException, ClassNotFoundException {
        ArrayList<UserPreferences> userPrefs = new ArrayList<UserPreferences>();
        Stream<UserPreferences> prefsStream = readAllUsersPreferences().stream();
        prefsStream.filter( i -> i.getUserId() == userId ).forEach( i -> userPrefs.add(i));
        return userPrefs;
    }
}
