package edu.bu.tbconde.tripoint.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class RecordsWriter {
    private String outfile;

    public RecordsWriter(String path) {
        outfile = path;
    }
    public RecordsWriter() {
        outfile= "src/edu/bu/tbconde/tripoint/io/transactionsRecord.txt";
    }
    public boolean writeRecord(String transaction, boolean append)  {
        /*The try-with-resources ensures that the resource is closed at the end of the statement. A resource is object
        that must be closed after the program is finished with it. In this case, BufferedWriter is a resource that
        implements the AutoCloseable interface, and, therefore, it is automatically closed when exiting a
        try-with-resources statement.
        sources:
        https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
        https://docs.oracle.com/javase/8/docs/api/java/lang/AutoCloseable.html
        */
        try (BufferedWriter br = new BufferedWriter(
                new FileWriter(outfile,
                        append)
        )) {
            br.write(transaction);
            br.write(System.lineSeparator());
            return true;
        }
        catch (IOException err) {
            err.printStackTrace();
            return false;
        }
    }
    public boolean deleteRecords() {
        return writeRecord("", false );
    }
}
