package piggy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;


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


class TransactionTableModel extends AbstractTableModel {
    
    private final String[] headers;
    private final List<Transaction> data;
    
    TransactionTableModel() {
        this.headers = createHeaders();
        this.data = new ArrayList<Transaction>();
    }
    
    void add(List<Transaction> transactions) {
        data.addAll(transactions);
        fireTableDataChanged();
    }
    
    @Override
    public String getColumnName(int column) {
        return headers[column];
    }
    
    @Override
    public int getColumnCount() {
        return headers.length;
    }
    
    @Override
    public int getRowCount() {
        return data.size();
    }
    
    @Override
    public Object getValueAt(int row, int col) {
        
        Transaction t = data.get(row);
        
        switch (col) {
        case 0: return t.getDate();
        case 1: return t.getAmount();
        case 2: return t.getCategory();
        case 3: return t.getDescription();
        default:
            throw new RuntimeException("Unexpected  column!");
        }
    }
    
    //---------------------------------
    // Helpers
    //
    
    private static String[] createHeaders() {
        return new String[] {
                "Date",
                "Amount",
                "Category",
                "Description"
        };
    }
}