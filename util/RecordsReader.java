package util;

import transactions.Transaction;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**This class reads the transactionsRecord file*/
public class RecordsReader {
    static void recordDisplay(String card, String category, double amount, int points) {
        System.out.printf("%-15s %-15s %-15d %-15d",
                card,
                category,
                amount,
                points);
    }
    ArrayList<Transaction> transRecords;
    public static void main(String[] args){
        try {
            Scanner infile = new Scanner(new File("io/transactionsRecord.txt"));
            System.out.printf("%-15s %-15s %-15s %-15s","CARD USED", "CATEGORY", "AMOUNT", "POINTS");
            while (infile.hasNext()) {
                System.out.printf("%-15s %-15s %-15d %-15d", infile.);
            }
            infile.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
