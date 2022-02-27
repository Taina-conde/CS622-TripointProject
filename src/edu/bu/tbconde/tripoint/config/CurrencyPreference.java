package edu.bu.tbconde.tripoint.config;

public class CurrencyPreference extends Preference{
    private String currency;
    public CurrencyPreference() {
        this(0, "dollar");
    }
    public CurrencyPreference(int userId) {
        super(userId);
        this.currency = "dollar";
    }
    public CurrencyPreference(int userId, String currency) {
        this(userId);
        this.currency = currency;
    }

    @Override
    public String getPref() {
        return currency;
    }

    @Override
    public void setPref(String currency) {
        this.currency = currency;
    }
    @Override
    public String toString() {
        return currency.substring(0,1).toUpperCase() + currency.substring(1);
    }
}
