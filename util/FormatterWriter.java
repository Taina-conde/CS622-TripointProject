package util;

import java.util.Formatter;
import java.io.FileNotFoundException;

public class FormatterWriter {
    public static void main(String[] args) {
        Formatter outfile = null;
        try {
            outfile = new Formatter("/Project/io/transactionsRecord.txt");
        }
        catch (FileNotFoundException ex) {

            System.err.println("Cannot open file ... quitting");

        }

        outfile.format("Wilfred Owen %4d%n", 25);
        outfile.format("W.B. Yeats %4d%n", 50);
        outfile.format("Rabindranath Tagore %4d%n", 2000);
        outfile.close();

    }

}
