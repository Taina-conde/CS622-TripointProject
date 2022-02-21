package edu.bu.tbconde.tripoint.database;
import edu.bu.tbconde.tripoint.util.User;

import java.sql.*;

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


}
