package piggy.gui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import piggy.data.Transaction;


/**
 * Model backing a table of transactions.
 */
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
            throw new RuntimeException("Unexpected column!");
        }
    }
    
    @Override
    public Class<?> getColumnClass(int col) {
        switch (col) {
        case 1: return Float.class;
        default:
            return String.class;
        }
    }
    
    @Override
    public boolean isCellEditable(int row, int col) {
        return (col == 2);
    }
    
    @Override
    public void setValueAt(Object value, int row, int col) {
        
        Transaction transaction = getTransaction(row);
        
        switch (col) {
        case 2:
            transaction.setCategory((String) value);
            break;
        default:
            break;
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
    
    private Transaction getTransaction(int row) {
        return data.get(row);
    }
}