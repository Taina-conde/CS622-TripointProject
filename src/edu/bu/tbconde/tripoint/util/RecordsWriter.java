package edu.bu.tbconde.tripoint.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class RecordsWriter {
    public static void writeRecord(String transaction, boolean append)  {
        /*The try-with-resources ensures that the resource is closed at the end of the statement. A resource is object
        that must be closed after the program is finished with it. In this case, BufferedWriter is a resource that
        implements the AutoCloseable interface, and, therefore, it is automatically closed when exiting a
        try-with-resources statement.
        sources:
        https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
        https://docs.oracle.com/javase/8/docs/api/java/lang/AutoCloseable.html
        */
        String fileName = "transactionsRecord.txt";
        String filePath = "src/edu/bu/tbconde/tripoint/io/";
        String outfile = filePath + fileName;
        try (BufferedWriter br = new BufferedWriter(
                new FileWriter(outfile,
                        append)
        )) {
            br.write(transaction);
            br.write(System.lineSeparator());
        }
        catch (IOException err) {
            err.printStackTrace();
        }
    }
    public static void writeRecord(String transaction) {
        writeRecord(transaction, true );
    }
}
