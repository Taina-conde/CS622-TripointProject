package edu.bu.tbconde.tripoint.util;

public class User {
    private int userId;
    private String firstName;
    private String lastName;
    private String username;
    //getters
    public int getUserId() {return userId;}
    public String getFirstName() {return firstName;}
    public String getLastName() {
        return lastName;
    }
    public String getUsername() {
        return username;
    }
    //setters

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
