package edu.bu.tbconde.tripoint.database;

import edu.bu.tbconde.tripoint.cards.BasicCard;
import edu.bu.tbconde.tripoint.cards.CreditCard;
import edu.bu.tbconde.tripoint.transactions.PurchaseTransaction;
import edu.bu.tbconde.tripoint.transactions.Transaction;
import edu.bu.tbconde.tripoint.util.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UseDataBaseTest {
    private UseDataBase db = null;
    private String url = "jdbc:sqlite:tests/edu/bu/tbconde/tripoint/database/DatabaseTest.db";
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
        assertEquals(user1.getId(), userTest.getId());
        assertEquals(user1.getFirstName(), userTest.getFirstName());
        assertEquals(user1.getLastName(), userTest.getLastName());
        assertEquals(user1.getUsername(), userTest.getUsername());
    }

    @Test
    void insertTrans() throws SQLException {
        try(Connection conn = DriverManager.getConnection(url)) {
            try {
                db.insertTrans(
                        conn,
                        trans1,
                        user1.getId()
                        );
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Test
    void searchUserTransactions() {
        
    }

    @Test
    void searchRecordsByType() {
    }

    @Test
    void calculatePointsBalance() {
    }
}