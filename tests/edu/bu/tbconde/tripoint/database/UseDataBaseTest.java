package edu.bu.tbconde.tripoint.database;

import edu.bu.tbconde.tripoint.cards.BasicCard;
import edu.bu.tbconde.tripoint.cards.CreditCard;
import edu.bu.tbconde.tripoint.transactions.PurchaseTransaction;
import edu.bu.tbconde.tripoint.transactions.Transaction;
import edu.bu.tbconde.tripoint.util.TransInfo;
import edu.bu.tbconde.tripoint.util.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UseDataBaseTest {
    private UseDataBase db = null;
    private String url = "jdbc:sqlite:tests/edu/bu/tbconde/tripoint/database/DatabaseTest.db";
    private String wrongUrl = "jdbc:sqlite:tests/edu/bu/tbconde/tripoint/database/WRONG.db";
    private User user1 = null;
    private CreditCard card = null;
    private Transaction trans1 = null;
    @BeforeEach
    void setUp() {
        db = new UseDataBase();
        user1 = new User(1,"Tiger", "Woods","twoods12" );
        card = new BasicCard();
        trans1 = new PurchaseTransaction(card, "travel", 500);
    }

    @AfterEach
    void tearDown() {
        db = null;
        user1 = null;
        card = null;
        trans1 = null;
    }

    @Test
    void createNewUser() throws SQLException {
        String user1pswrd = "day1810";
        try(Connection conn = DriverManager.getConnection(url)) {
            try {
                db.createNewUser(
                        conn,
                        user1.getFirstName(),
                        user1.getLastName(),
                        user1.getUsername(),
                        user1pswrd);
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    @Test
    void createNewUserThrowsSqlException() throws SQLException {
        String user1pswrd = "day1810";
        try(Connection conn = DriverManager.getConnection(wrongUrl)) {
            assertThrows(SQLException.class, () -> db.createNewUser(conn,user1.getFirstName(),
                    user1.getLastName(),
                    user1.getUsername(),
                    user1pswrd ));
        }
    }

    @Test
    void searchUser() throws SQLException{
        String user1pswrd = "day1810";
        User userTest = null;
        try(Connection conn = DriverManager.getConnection(url)) {
            try {
                userTest = db.searchUser(
                        conn,
                        user1.getUsername(),
                        user1pswrd);
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        assertEquals(user1.getFirstName(), userTest.getFirstName());
        assertEquals(user1.getLastName(), userTest.getLastName());
        assertEquals(user1.getUsername(), userTest.getUsername());
    }
    @Test
    void searchUserNull() throws SQLException{
        String notRegisteredUserUsername = "greg7";
        String notRegisteredUserpswrd = "112jj";
        User userTest = null;
        try(Connection conn = DriverManager.getConnection(url)) {
            try {
                userTest = db.searchUser(
                        conn,
                        notRegisteredUserUsername,
                        notRegisteredUserpswrd);
                assertNull(userTest);
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    @Test
    void searchUserIncorrectPassword() throws SQLException{
        String incorrectPswrd = "112jj";
        User userTest = null;
        try(Connection conn = DriverManager.getConnection(url)) {
            try {
                userTest = db.searchUser(
                        conn,
                        user1.getUsername(),
                        incorrectPswrd);
                assertNull(userTest);
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    @Test
    void searchUserThrowsSqlException() throws SQLException {
        String username = user1.getUsername();
        String user1pswrd = "day1810";
        try(Connection conn = DriverManager.getConnection(wrongUrl)) {
            assertThrows(SQLException.class, () -> db.searchUser(conn, username,
                    user1pswrd ));
        }
    }

    @Test
    void insertTrans() throws SQLException {
        try(Connection conn = DriverManager.getConnection(url)) {
            try {
                db.insertTrans(
                        conn,
                        trans1,
                        1
                        );
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    @Test

    void insertTransThrowsSQLException() throws SQLException {
        try(Connection conn = DriverManager.getConnection(wrongUrl)) {
            assertThrows(SQLException.class, () -> db.insertTrans(conn, trans1,
                    1));
        }
    }

    @Test
    void searchUserTransactions() throws SQLException {
        ArrayList<TransInfo> transList;
        try(Connection conn = DriverManager.getConnection(url)) {
            try {
                transList = db.searchUserTransactions(
                        conn,
                        1
                );
                assertEquals(trans1.getType(), transList.get(0).getType());
                assertEquals(trans1.getCategory(), transList.get(0).getCategory());
                assertEquals(trans1.getCardType(), transList.get(0).getCardUsed());
                assertEquals(trans1.getAmount(), transList.get(0).getAmount());
                assertEquals(trans1.getPoints(), transList.get(0).getPoints());
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    @Test
    void searchUserTransactionsThrowsSQLException() throws SQLException {
        try(Connection conn = DriverManager.getConnection(wrongUrl)) {
            assertThrows(SQLException.class, () -> db.searchUserTransactions(conn,
                    1));
        }
    }

    @Test
    void searchRecordsByType() throws SQLException {
        ArrayList<TransInfo> transList1;
        ArrayList<TransInfo> transList2;
        try(Connection conn = DriverManager.getConnection(url)) {
            try {
                transList1 = db.searchRecordsByType(
                        conn,
                        1,
                        "purchase"
                );
                assertEquals(trans1.getType(), transList1.get(0).getType());
                assertEquals(trans1.getCategory(), transList1.get(0).getCategory());
                assertEquals(trans1.getCardType(), transList1.get(0).getCardUsed());
                assertEquals(trans1.getAmount(), transList1.get(0).getAmount());
                assertEquals(trans1.getPoints(), transList1.get(0).getPoints());
                transList2 = db.searchRecordsByType(
                        conn,
                        1,
                        "redeem"
                );
                assertEquals(0, transList2.size());

            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    @Test
    void searchRecordsByTypeThrowsSQLException() throws SQLException {
        try(Connection conn = DriverManager.getConnection(wrongUrl)) {
            assertThrows(SQLException.class, () -> db.searchRecordsByType(conn,
                    1, "purchase"));
        }
    }

    @Test
    void calculatePointsBalance() throws SQLException {
        ArrayList<TransInfo> transList;
        try(Connection conn = DriverManager.getConnection(url)) {
            try {
                transList = db.searchUserTransactions(conn, 1);
                int listSize = transList.size();
                int expectedPointsBalance = listSize * transList.get(0).getPoints();
                int actualPointsBalance = db.calculatePointsBalance(
                        conn,
                        1
                );
                assertEquals(expectedPointsBalance, actualPointsBalance );
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    @Test
    void calculatePointsBalanceThrowsSQLException() throws SQLException {
        try(Connection conn = DriverManager.getConnection(wrongUrl)) {
            assertThrows(SQLException.class, () -> db.calculatePointsBalance(conn,
                    1));
        }
    }
}