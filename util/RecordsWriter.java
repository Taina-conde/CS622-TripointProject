package util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class RecordsWriter {
    public static void writeRecord(String transaction) {
        try {
            FileWriter fr = new FileWriter("io/transactionsRecord.txt", true);
            BufferedWriter br = new BufferedWriter(fr);
            br.write(transaction);
            br.write(System.lineSeparator());
            br.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
