package edu.bu.tbconde.tripoint.util;

import edu.bu.tbconde.tripoint.transactions.Transaction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Callable;

public class InitializeRecordsThread implements Callable<ArrayList<Transaction>> {
    private ArrayList<Transaction> records;
    private RecordsReader reader;
    private RecordsWriter writer;
    public InitializeRecordsThread() {
        records = new ArrayList<Transaction>();
        reader = new RecordsReader();
        writer = new RecordsWriter();
    }
    public InitializeRecordsThread(String path) {
        records = new ArrayList<Transaction>();
        reader = new RecordsReader(path);
        writer = new RecordsWriter(path);
    }
    public ArrayList<Transaction> call() throws ClassNotFoundException{
        try {
            records = reader.readRecords();
        }
        catch (IOException ex) {
            try { writer.writeRecords(records);}
            catch(IOException err) {
                err.printStackTrace();
            }
        }
        return records;
    }
}
