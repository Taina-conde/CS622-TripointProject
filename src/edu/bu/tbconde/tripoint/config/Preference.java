package edu.bu.tbconde.tripoint.config;

import java.io.Serializable;

public abstract class Preference implements Serializable {
    private int userId;
    public Preference(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }
    public abstract String getPref();
    public abstract void setPref(String pref);
}
