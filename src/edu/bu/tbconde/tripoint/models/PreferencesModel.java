package edu.bu.tbconde.tripoint.models;

public class PreferencesModel {
    private String currency;
    private String orderBy;

    public String getCurrency() {
        return currency;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}
