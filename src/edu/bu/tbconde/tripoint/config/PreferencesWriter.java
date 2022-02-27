package edu.bu.tbconde.tripoint.config;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PreferencesWriter {
    private String path;

    public PreferencesWriter(String path) {
        this.path = path;
    }
    public PreferencesWriter() {
        this.path = "/preferences.dat";
    }
    public boolean writePreferences(ArrayList<UserPreferences> prefs) throws IOException {
        /*The try-with-resources ensures that the resource is closed at the end of the statement. A resource is object
        that must be closed after the program is finished with it. In this case, ObjectOutputStream is a resource that
        implements the AutoCloseable interface, and, therefore, it is automatically closed when exiting a
        try-with-resources statement.
        sources:
        https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
        https://docs.oracle.com/javase/8/docs/api/java/lang/AutoCloseable.html
        */
        try (ObjectOutputStream outfile = new ObjectOutputStream(
                new FileOutputStream(path)
        )) {
            outfile.writeObject(prefs);
            return true;
        }
    }

}

