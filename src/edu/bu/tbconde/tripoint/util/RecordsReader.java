package edu.bu.tbconde.tripoint.util;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import edu.bu.tbconde.tripoint.exceptions.IncorrectFileNameException;

/**This class reads the transactionsRecord file, printing the formatted records*/
public class RecordsReader {
    protected static void printRecord(String card, String category, String amount, String points) {
        System.out.printf("%-30s %-30s %-30s %-30s\n",
                card,
                category,
                amount,
                points);
    }
    public static void printAllRecords() throws IncorrectFileNameException {
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
            System.out.println();
            System.out.println("Your past transactions ...");
            System.out.println();
            System.out.printf("%-30s %-30s %-30s %-30s\n","CARD USED", "CATEGORY", "AMOUNT", "POINTS");
            while (sc.hasNextLine()) {
                String[] arr = sc.nextLine().split(", ");
                if (arr.length > 1) {
                    printRecord(arr[0], arr[1], arr[2], arr[3]);
                }
            }
        }
        catch (FileNotFoundException err) {
            if (!filePath.equals("src/edu/bu/tbconde/tripoint/io/")) {
                throw new IncorrectFileNameException("Incorrect path: " + filePath, err);
            }
            else if (!fileName.equals("transactionsRecord.txt")) {
                throw new IncorrectFileNameException("Incorrect file name: " + fileName, err);
            }
            else{
                System.out.println(err);
            }
        }
    }
}
