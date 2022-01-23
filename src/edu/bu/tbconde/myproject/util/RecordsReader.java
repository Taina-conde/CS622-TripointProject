package edu.bu.tbconde.myproject.util;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**This class reads the transactionsRecord file, printing the formatted records*/
public class RecordsReader {
    protected static void printRecord(String card, String category, String amount, String points) {
        System.out.printf("%-30s %-30s %-30s %-30s\n",
                card,
                category,
                amount,
                points);
    }
    public static void printAllRecords() {
        /*The try-with-resources ensures that the resource is closed at the end of the statement. A resource is object
        that must be closed after the program is finished with it. In this case, Scanner is a resource that
        implements the AutoCloseable interface, and, therefore, it is automatically closed when exiting a
        try-with-resources statement.
        sources:
        https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
        https://docs.oracle.com/javase/8/docs/api/java/lang/AutoCloseable.html
        */
        try (Scanner infile = new Scanner(new File("io/transactionsRecord.txt"))) {
            System.out.println();
            System.out.println("Your past transactions ...");
            System.out.println();
            System.out.printf("%-30s %-30s %-30s %-30s\n","CARD USED", "CATEGORY", "AMOUNT", "POINTS");
            while (infile.hasNextLine()) {
                String[] arr = infile.nextLine().split(", ");
                if (arr.length > 1) {
                    printRecord(arr[0], arr[1], arr[2], arr[3]);
                }
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}
