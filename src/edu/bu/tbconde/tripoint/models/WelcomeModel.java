package edu.bu.tbconde.tripoint.models;

public class WelcomeModel {
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    public WelcomeModel(String username) {
        this.username = username;
    }
    public WelcomeModel() {
        this(null);
    }
    public String getUsername() {return username;}
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public String getPassword() {return password;}
    public void setUsername(String username) {this.username = username;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public void setPassword(String password){this.password = password;}
}
