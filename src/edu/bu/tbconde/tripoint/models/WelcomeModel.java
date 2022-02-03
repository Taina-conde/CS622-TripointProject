package edu.bu.tbconde.tripoint.models;

public class WelcomeModel {
    private String username;
    public WelcomeModel(String username) {
        this.username = username;
    }
    public WelcomeModel() {
        this(null);
    }
    public String getUsername() {return username;}
    public void setUsername(String name) {this.username = name;}
}
