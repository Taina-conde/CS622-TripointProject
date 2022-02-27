package edu.bu.tbconde.tripoint.config;

public class CurrencyPreference extends Preference{
    private String currency;
    public CurrencyPreference(int userId) {
        super(userId);
    }

    @Override
    public String getPref() {
        return currency;
    }

    @Override
    public void setPref(String currency) {
        this.currency = currency;
    }
}
