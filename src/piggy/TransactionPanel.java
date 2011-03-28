package piggy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;


/**
 * Panel for holding the transactions.
 */
public class TransactionPanel extends Box {
    
    TransactionTableModel model = new TransactionTableModel();
    JTable table = new JTable(model);
    JScrollPane pane = new JScrollPane(table);
    
    TransactionPanel() {
        super(BoxLayout.PAGE_AXIS);
        add(pane);
    }
    
    void load(File file) throws FileNotFoundException {
        
        List<Transaction> transactions = new LinkedList<Transaction>();
        Scanner scanner = new Scanner(file);
        Transaction transaction;
        String line, value;
        char key;
        
        scanner.nextLine();
        
        transaction = new Transaction();
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            key = line.charAt(0);
            value = line.substring(1);
            if (key == '^') {
                transactions.add(transaction);
                transaction = new Transaction();
            } else {
                apply(transaction, key, value);
            }
        }
        model.add(transactions);
    }
    
    void apply(Transaction transaction, char key, String value) {
        switch (key) {
        case 'D':
            transaction.setDate(value);
            break;
        case 'T':
            transaction.setAmount(value);
            break;
        case 'P':
            transaction.setDescription(value);
            break;
        }
    }
    
    static String getLine(Scanner scanner, int i) {
        return scanner.nextLine().substring(i);
    }
}
