package edu.bu.tbconde.tripoint.util;

import edu.bu.tbconde.tripoint.transactions.Transaction;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class RecordsWriter {
    private String path;

    public RecordsWriter(String path) {
        this.path = path;
    }
    public RecordsWriter() {
        this.path = "src/edu/bu/tbconde/tripoint/io/transactionsRecord.dat";
    }
    public boolean writeRecords(ArrayList<Transaction> records) throws IOException {
        /*The try-with-resources ensures that the resource is closed at the end of the statement. A resource is object
        that must be closed after the program is finished with it. In this case, ObjectOutputStream is a resource that
        implements the AutoCloseable interface, and, therefore, it is automatically closed when exiting a
        try-with-resources statement.
        sources:
        https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
        https://docs.oracle.com/javase/8/docs/api/java/lang/AutoCloseable.html
        */
        try (ObjectOutputStream outfile = new ObjectOutputStream(
                new FileOutputStream(path)
        )) {
            outfile.writeObject(records);
            return true;
        }
    }
}
