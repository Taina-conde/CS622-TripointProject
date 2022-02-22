package edu.bu.tbconde.tripoint.database;
import edu.bu.tbconde.tripoint.transactions.Transaction;
import edu.bu.tbconde.tripoint.util.User;

import java.sql.*;
import java.util.ArrayList;

public class UseDataBase {
    public void createNewUser(Connection conn, String firstName, String lastName, String username, String password) throws SQLException{
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
    public void insertTrans(Connection conn, Transaction trans, int userId) throws SQLException {
        String sql = "INSERT INTO Trans(type, card_used, category, amount, points, timestamp, user_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
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
    public void searchUserTransactions(Connection conn, int userId) throws SQLException {
        String sql = "SELECT type, card_used, category, amount, points, timestamp FROM Trans WHERE " +
                "user_id = ? ORDER BY timestamp DESC";
        String type ;
        String cardUsed;
        String category;
        double amount;
        int points;
        Date timestamp;
        try ( PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            query(pstmt);
        }

    }
    public void searchRecordsByType(Connection conn, int userId, String typeSearched) throws SQLException {
        String sql = "SELECT type, card_used, category, amount, points, timestamp FROM Trans WHERE " +
                "user_id = ? AND type = ?  ORDER BY timestamp DESC";

        try ( PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            pstmt.setString(2, typeSearched);
            query(pstmt);
        }
    }
    private void query(PreparedStatement pstmt) throws SQLException {
        boolean hasTrans = false;
        String type;
        String cardUsed;
        String category;
        double amount;
        int points;
        Date timestamp;
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()) {
            hasTrans = true;
            type = rs.getString(1);
            cardUsed = rs.getString(2);
            category = rs.getString(3);
            amount = rs.getDouble(4);
            points = rs.getInt(5);
            timestamp = rs.getDate(6);
            if (type.equals("redeem")) {
                points = -points;
            }
            System.out.printf("%-30s %-30s %-30s $%-29.2f %,-30d %-30s\n",
                    type,
                    cardUsed,
                    category,
                    amount,
                    points,
                    timestamp
            );
        }
        if (!hasTrans) {
            System.out.println("You haven't made any transactions yet.");
        }

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



}
