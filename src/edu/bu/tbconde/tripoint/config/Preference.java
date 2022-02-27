package edu.bu.tbconde.tripoint.config;

public abstract class Preference {
    private int userId;
    public Preference(int userId) {
        this.userId = userId;
    }
    public abstract String getPref();
    public abstract void setPref(String pref);
}
