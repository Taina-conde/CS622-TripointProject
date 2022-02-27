package edu.bu.tbconde.tripoint.config;

public class OrderByPreference extends Preference {
    private String orderBy;
    public OrderByPreference(int userId) {
        super(userId);
        this.orderBy = "timestamp DESC";
    }
    public OrderByPreference(int userId, String orderBy) {
        this(userId);
        this.orderBy = orderBy;
    }
    public String orderText() {
        switch (orderBy) {
            case "timestamp DESC":
                return "most recent";
            case "timestamp ASC":
                return "oldest";
            case "amount DESC":
                return "greatest amount";
            case "amount ASC" :
                return "lowest amount";
            default:
                return "type";
        }
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
        return orderText().substring(0,1).toUpperCase() + orderText().substring(1);
    }
}
