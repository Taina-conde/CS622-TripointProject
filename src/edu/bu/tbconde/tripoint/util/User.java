package edu.bu.tbconde.tripoint.util;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String username;
    public User() {

    }
    public User(int id, String firstName, String lastName, String username) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.id = id;

    }
    //getters
    public int getId() {return id;}
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

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
