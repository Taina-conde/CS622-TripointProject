package edu.bu.tbconde.tripoint.database;
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
    public void searchUser(Connection conn, String un, String pswd) throws SQLException {
        String sql = "SELECT user_id, first_name, last_name, username, password FROM User WHERE " +
                "username LIKE "+ un + " AND password LIKE "+ pswd;
        try (Statement stmt = conn.createStatement();
        ResultSet rs = stmt. executeQuery(sql)) {
            while(rs.next()) {

            }
        }
    }


}
