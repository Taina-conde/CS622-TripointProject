package edu.bu.tbconde.tripoint.util;

import edu.bu.tbconde.tripoint.transactions.Transaction;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;


/**This class reads the transactionsRecord file*/
public class RecordsReader {
    private ArrayList<Transaction> records;
    private String path = "src/edu/bu/tbconde/tripoint/io/transactionsRecord.dat";
    public RecordsReader() {
        records = new ArrayList<Transaction>();
    }
    public RecordsReader(String path) {
        this();
        this.path = path;

    }
    public ArrayList<Transaction> readRecords() throws IOException, ClassNotFoundException {
        /*The try-with-resources ensures that the resource is closed at the end of the statement. A resource is object
        that must be closed after the program is finished with it. In this case, ObjectInputStream is a resource that
        implements the AutoCloseable interface, and, therefore, it is automatically closed when exiting a
        try-with-resources statement.
        sources:
        https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
        https://docs.oracle.com/javase/8/docs/api/java/lang/AutoCloseable.html
        */
        try (ObjectInputStream infile = new ObjectInputStream(new FileInputStream(path))) {
            boolean hasNextObj = true;
            while (hasNextObj) {
                Transaction trans = (Transaction)infile.readObject();
                if (trans != null) {
                    records.add(trans);
                } else {
                    hasNextObj = false;
                }
            }
        }
        catch (FileNotFoundException ex) {
            System.out.println("You haven't made any transactions yet.");
        }
        return records;
    }
}
