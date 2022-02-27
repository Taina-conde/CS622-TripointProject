package edu.bu.tbconde.tripoint.models;

public class PreferencesModel {
    private String currency;
    private String orderBy;
    private String currencyOption1 = "1.Dollar  \n ";
    private String currencyOption2 = "2.Euro \n ";
    private String orderOption1 = "1.Most recent  \n ";
    private String orderOption2 = "2.Oldest \n ";
    private String orderOption3 = "3.Greatest amount \n ";
    private String orderOption4 = "4.Lowest amount \n ";
    private String orderOption5 = "5.Type \n ";

    public String getCurrency() {
        return currency;
    }

    public String getOrderBy() {
        return orderBy;
    }
    public String getCurrencyOption1() {return currencyOption1;}

    public String getCurrencyOption2() {
        return currencyOption2;
    }

    public String getOrderOption1() {
        return orderOption1;
    }

    public String getOrderOption2() {
        return orderOption2;
    }

    public String getOrderOption3() {
        return orderOption3;
    }

    public String getOrderOption4() {
        return orderOption4;
    }

    public String getOrderOption5() {
        return orderOption5;
    }

    public void setCurrencyOption1(String currencyOption1) {
        this.currencyOption1 = currencyOption1;
    }

    public void setCurrencyOption2(String currencyOption2) {
        this.currencyOption2 = currencyOption2;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}
