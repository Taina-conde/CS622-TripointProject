package edu.bu.tbconde.tripoint.models;

public class MainMenuModel {
    private String option1 = "1.Register a new purchase \n ";
    private String option2 = "2.View past transactions \n ";
    private String option3 = "3.Redeem points \n ";
    private String option4 = "4.Check your points balance \n ";
    private String option5 = "5.Close account \n ";
    private String option6 = "6.Set Preferences \n ";
    private String option7 = "7.Logout \n";
    private int selectedOption;
    //getters
    public String getOption1() { return option1;}
    public String getOption2() { return option2;}
    public String getOption3() { return option3;}
    public String getOption4() { return option4;}
    public String getOption5() { return option5;}
    public String getOption6(){ return option6;}
    public String getOption7() { return option7;}
    public int getSelectedOption() {return selectedOption;}
    //setters
    public void setSelectedOption(int selected) {this.selectedOption = selected;}
}
