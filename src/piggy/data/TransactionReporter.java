package piggy.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TransactionReporter {
    
    /**
     * Generates a report.
     * 
     * @param file
     * @param transactions
     * @throws FileNotFoundException 
     */
    public static void report(final File file,
                              final List<Transaction> transactions) {
        
        Map<String,Float> sums = compute(transactions);
        
        try {
            save(file, sums);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
    
    //------------------------------------------------------------
    // Helpers
    //

    private static Map<String,Float> compute(List<Transaction> transactions) {
        
        Map<String,Float> sums = new HashMap<String,Float>();
        String category;
        float amount;
        Float sum;
        
        for (Transaction transaction : transactions) {
            category = transaction.getCategory();
            if (!isEmpty(category)) {
                sum = sums.get(category);
                amount = transaction.getAmount();
                if (sum == null) {
                    sum = amount;
                } else {
                    sum += amount;
                }
                sums.put(category, sum);
            }
        }
        return sums;
    }
    
    private static void save(final File file,
                             final Map<String,Float> sums)
                             throws FileNotFoundException {
        
        PrintWriter pw = new PrintWriter(file);
        String k;
        Float v;
        
        for (Map.Entry<String,Float> entry : sums.entrySet()) {
            k = entry.getKey();
            v = entry.getValue();
            pw.printf("%s %f\n", k, v);
        }
        pw.close();
    }
    
    private static boolean isEmpty(String str) {
        return (str == null) || (str.isEmpty());
    }
}
