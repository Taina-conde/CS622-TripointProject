package edu.bu.tbconde.tripoint.config;

public class OrderByPreference extends Preference {
    private String orderBy;
    public OrderByPreference(int userId) {
        super(userId);
    }

    @Override
    public String getPref() {
        return orderBy;
    }

    @Override
    public void setPref(String orderBy) {
        this.orderBy = orderBy;
    }
}
