package piggy.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Utility for loading transactions from a file.
 */
public class TransactionParser {
    
    /**
     * Parses a file into transactions.
     * 
     * @param file File in QIF format
     * @return Transactions loaded from file
     * @throws FileNotFoundException if file does not exists
     */
    public static List<Transaction> parse(File file)
                                          throws FileNotFoundException {
        
        List<Transaction> transactions = new ArrayList<Transaction>();
        Scanner scanner = new Scanner(file);
        Transaction transaction = new Transaction();
        String line, value;
        char key;
        
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            key = line.charAt(0);
            value = line.substring(1);
            if (key != '^') {
                apply(transaction, key, value);
            } else {
                transactions.add(transaction);
                transaction = new Transaction();
            }
        }
        return transactions;
    }
    
    //--------------------------------------------------
    // Helpers
    //
    
    /**
     * Stores a value in a transaction.
     * 
     * @param transaction Existing transaction
     * @param k Key
     * @param v Value
     */
    private static void apply(Transaction transaction, char k, String v) {
        switch (k) {
        case 'D':
            transaction.setDate(v);
            break;
        case 'T':
            transaction.setAmount(v);
            break;
        case 'P':
            transaction.setDescription(v);
            break;
        }
    }
}
