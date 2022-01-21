package util;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**This class reads the transactionsRecord file, printing the formatted records*/
public class RecordsReader {
    protected static void printRecord(String card, String category, String amount, String points) {
        System.out.printf("%-30s %-30s %-30s %-30s\n",
                card,
                category,
                amount,
                points);
    }
    public static void printAllRecords() {
        try {
            Scanner infile = new Scanner(new File("io/transactionsRecord.txt"));
            System.out.println();
            System.out.println("Your past transactions ...");
            System.out.println();
            System.out.printf("%-30s %-30s %-30s %-30s\n","CARD USED", "CATEGORY", "AMOUNT", "POINTS");
            while (infile.hasNextLine()) {
                String[] arr = infile.nextLine().split(", ");
                if (arr.length > 1) {
                    printRecord(arr[0], arr[1], arr[2], arr[3]);
                }
            }
            infile.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
