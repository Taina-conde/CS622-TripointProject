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


}
