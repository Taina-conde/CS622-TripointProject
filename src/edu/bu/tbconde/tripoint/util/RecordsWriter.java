package edu.bu.tbconde.tripoint.util;

import edu.bu.tbconde.tripoint.exceptions.IncorrectFileNameException;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import edu.bu.tbconde.tripoint.exceptions.IncorrectFileNameException;

public class RecordsWriter {
    public static void writeRecord(String transaction) throws IncorrectFileNameException {
        /*The try-with-resources ensures that the resource is closed at the end of the statement. A resource is object
        that must be closed after the program is finished with it. In this case, BufferedWriter is a resource that
        implements the AutoCloseable interface, and, therefore, it is automatically closed when exiting a
        try-with-resources statement.
        sources:
        https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
        https://docs.oracle.com/javase/8/docs/api/java/lang/AutoCloseable.html
        */
        String fileName = "transactionRecord.txt";
        String filePath = "src/edu/bu/tbconde/tripoint/io/";
        String outfile = filePath + fileName;
        try (BufferedWriter br = new BufferedWriter(
                new FileWriter(outfile,
                        true)
        )) {
            br.write(transaction);
            br.write(System.lineSeparator());
        }
        catch (IOException err) {
            if (!filePath.equals("src/edu/bu/tbconde/tripoint/io/")) {
                throw new IncorrectFileNameException("Incorrect path: " + filePath, err);
            }
            else if (!fileName.equals("transactionsRecord.txt")) {
                throw new IncorrectFileNameException("Incorrect file name: " + fileName, err);
            }
        }
    }
}
