package edu.bu.tbconde.tripoint.util;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

/**This class reads the transactionsRecord file, printing the formatted records*/
public class RecordsReader {
    private ArrayList<String> lines;
    private String infile;
    public RecordsReader() {
        infile = "src/edu/bu/tbconde/tripoint/io/transactionsRecord.txt";
        lines = new ArrayList<>();
    }
    public ArrayList<String> readLine() {
        /*The try-with-resources ensures that the resource is closed at the end of the statement. A resource is object
        that must be closed after the program is finished with it. In this case, Scanner is a resource that
        implements the AutoCloseable interface, and, therefore, it is automatically closed when exiting a
        try-with-resources statement.
        sources:
        https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
        https://docs.oracle.com/javase/8/docs/api/java/lang/AutoCloseable.html
        */
        try (Scanner sc = new Scanner(new File(infile))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line != null) {
//                    System.out.println("Your past transactions ...");
//                    System.out.println();
//                    System.out.printf("%-30s %-30s %-30s %-30s\n","CARD USED", "CATEGORY", "AMOUNT", "POINTS");
                    lines.add(line);
                }
            }

        }
        catch (FileNotFoundException err) {
            err.printStackTrace();
        }
        return lines;
    }
}
