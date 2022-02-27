package edu.bu.tbconde.tripoint.config;

public class OrderByPreference extends Preference {
    private String orderBy;
    public OrderByPreference(int userId) {
        super(userId);
    }
    public OrderByPreference(int userId, String orderBy) {
        this(userId);
        this.orderBy = orderBy;
    }

    @Override
    public String getPref() {
        return orderBy;
    }

    @Override
    public void setPref(String orderBy) {
        this.orderBy = orderBy;
    }
    @Override
    public String toString() {
        return orderBy.substring(0,1).toUpperCase() + orderBy.substring(1);
    }
}
