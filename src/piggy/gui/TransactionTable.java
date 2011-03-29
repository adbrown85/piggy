package piggy.gui;

import java.util.List;
import javax.swing.JTable;
import piggy.data.Transaction;


/**
 * Table of transactions.
 */
public class TransactionTable extends JTable {
    
    private final TransactionTableModel model;
    
    /**
     * Creates a transaction table.
     */
    TransactionTable() {
        super(new TransactionTableModel());
        model = (TransactionTableModel) getModel();
    }
    
    /**
     * Adds transactions to the table.
     * 
     * @param transactions
     */
    void add(List<Transaction> transactions) {
        model.add(transactions);
    }
}
