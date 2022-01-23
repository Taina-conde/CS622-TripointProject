package edu.bu.tbconde.myproject.transactions_test;

import edu.bu.tbconde.myproject.cards.BasicCard;
import edu.bu.tbconde.myproject.cards.CreditCard;
import edu.bu.tbconde.myproject.cards.PreferredCard;
import edu.bu.tbconde.myproject.transactions.CategoryTransaction;
import edu.bu.tbconde.myproject.transactions.Transaction;

class TransactionTest {
    static void transactionDisplayExample() {
        CreditCard basicCard = new BasicCard("Taina", 5000);
        Transaction newTrans = new CategoryTransaction(basicCard,"travel", 55.60);

    }

    public static void main(String[] args) {
//        CreditCard basicCard = new BasicCard("Taina", 5000);
//        CreditCard preferredCard = new PreferredCard("Taina");
//
//        //testing method calculatePoints using basicCard
//        Transaction newTrans = new CategoryTransaction(basicCard,"travel", 55.60);
//        int pointsEarned = newTrans.calculatePoints();
//        newTrans.saveTransaction();
//        assert pointsEarned == 278 : "The method calculatePoints returned " + pointsEarned + " but it should have returned 278";
//
//        //testing method calculatePoints using preferredCard
//        newTrans = new CategoryTransaction(preferredCard,"grocery", 10);
//        pointsEarned = newTrans.calculatePoints();
//        newTrans.saveTransaction();
//        assert pointsEarned == 30 : "The method calculatePoints returned " + pointsEarned + " but it should have returned 30";
//
//        //report transaction information to the console
//        System.out.println("=========TransactionDisplayExample==========");
//        transactionDisplayExample();

    }
}
