package edu.bu.tbconde.tripoint.controllers;

import edu.bu.tbconde.tripoint.models.PastTransactionsModel;
import edu.bu.tbconde.tripoint.views.PastTransactionsView;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PastTransactionsController {
    private PastTransactionsModel model = new PastTransactionsModel();
    private PastTransactionsView view = new PastTransactionsView();
    private void readRecords() {
           /*The try-with-resources ensures that the resource is closed at the end of the statement. A resource is object
        that must be closed after the program is finished with it. In this case, Scanner is a resource that
        implements the AutoCloseable interface, and, therefore, it is automatically closed when exiting a
        try-with-resources statement.
        sources:
        https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
        https://docs.oracle.com/javase/8/docs/api/java/lang/AutoCloseable.html
        */
        String fileName = "transactionsRecord.txt";
        String filePath = "src/edu/bu/tbconde/tripoint/io/";
        String infile = filePath + fileName;
        try (Scanner sc = new Scanner(new File(infile))) {
            while (sc.hasNextLine()) {
                String[] arr = sc.nextLine().split(", ");
                if (arr.length > 1) {
                    model.setCardType(arr[0]);
                    model.setCategory(arr[1]);
                    model.setAmount(arr[2]);
                    model.setPoints(arr[3]);
                }
                view.printRecord(
                        model.getCardType(),
                        model.getCategory(),
                        model.getAmount(),
                        model.getPoints()
                );
            }
        }
        catch (FileNotFoundException err) {
            System.out.println("You have not made any transactions yet.");
        }
    }
    public void displayPastTransactions() {
        view.printHeader();
        readRecords();
    }
}
