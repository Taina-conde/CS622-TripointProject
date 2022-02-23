package edu.bu.tbconde.tripoint.database;
import edu.bu.tbconde.tripoint.transactions.Transaction;
import edu.bu.tbconde.tripoint.util.TransInfo;
import edu.bu.tbconde.tripoint.util.User;

import java.sql.*;
import java.util.ArrayList;

public class UseDataBase {
    public void createNewUser(Connection conn, String firstName, String lastName, String username, String password)
            throws SQLException{
        String sql = "INSERT INTO User(first_name, last_name, username, password) VALUES (?, ?, ?, ?)";
        try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, username);
            pstmt.setString(4, password);
            pstmt.executeUpdate();
        }

    }
    public User searchUser(Connection conn, String un, String pswd) throws SQLException {
        String sql = "SELECT user_id, first_name, last_name, username, password FROM User WHERE " +
                "username = ? AND password = ?";
        User user = null;
        try ( PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, un);
            pstmt.setString(2, pswd);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
        }
        return user;
    }
    public void  insertTrans(Connection conn, Transaction trans, int userId) throws SQLException {
        String sql = "INSERT INTO Trans(type, card_used, category, amount, points, timestamp, user_id)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?)";
        try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, trans.getType());
            pstmt.setString(2, trans.getCardType());
            pstmt.setString(3, trans.getCategory());
            pstmt.setDouble(4, trans.getAmount());
            pstmt.setInt(5, trans.getPoints());
            pstmt.setDate(6,trans.getTimestamp());
            pstmt.setInt(7, userId);
            pstmt.executeUpdate();
        }
    }
    public ArrayList<TransInfo> searchUserTransactions(Connection conn, int userId) throws SQLException {
        String sql = "SELECT first_name, last_name, type, card_used, category, amount, points, timestamp" +
                " FROM User INNER JOIN Trans on User.user_id = Trans.user_id " +
                " WHERE Trans.user_id = ?" +
                " ORDER BY timestamp DESC";
        try ( PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<TransInfo> transList = query(rs);
            return transList;
        }
    }
    public ArrayList<TransInfo> searchRecordsByType(Connection conn, int userId, String typeSearched)
            throws SQLException {
        String sql = "SELECT first_name, last_name, type, card_used, category, amount, points, timestamp"+
                " FROM User INNER JOIN Trans on User.user_id = Trans.user_id " +
                " WHERE Trans.user_id = ? AND type = ?  ORDER BY timestamp DESC";
        try ( PreparedStatement pstmt = conn.prepareStatement(sql) ) {
            pstmt.setInt(1, userId);
            pstmt.setString(2, typeSearched);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<TransInfo> transInfoList = query(rs);
            return transInfoList;
        }
    }
    private ArrayList<TransInfo> query(ResultSet rs) throws SQLException {
        ArrayList<TransInfo> transInfoList = new ArrayList<TransInfo>();
        String firstName;
        String lastName;
        String type;
        String cardUsed;
        String category;
        double amount;
        int points;
        Timestamp timestamp;
        while(rs.next()) {
            firstName = rs.getString(1);
            lastName = rs.getString(2);
            type = rs.getString(3);
            cardUsed = rs.getString(4);
            category = rs.getString(5);
            amount = rs.getDouble(6);
            points = rs.getInt(7);
            timestamp = rs.getTimestamp(8);

            if (type.equals("redeem")) {
                points = -points;
            }
            TransInfo transInfo = new TransInfo(
                    firstName,
                    lastName,
                    type,
                    cardUsed,
                    category,
                    amount,
                    points,
                    timestamp
            );
            transInfoList.add(transInfo);
        }
        return transInfoList;
    }

    public int calculatePointsBalance(Connection conn, int userId) throws SQLException {
        int purchasePoints = 0;
        int redeemPoints = 0;
        String sql = "SELECT SUM(points) FROM Trans WHERE " +
                "user_id = ? AND type LIKE 'purchase'";
        try ( PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
             purchasePoints = rs.getInt(1);
        }
        sql = "SELECT SUM(points) FROM Trans WHERE " +
                "user_id = ? AND type LIKE 'redeem'";
        try ( PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            redeemPoints = rs.getInt(1);
        }
        return purchasePoints - redeemPoints;
    }
    public void deleteUser() {

    }




}
