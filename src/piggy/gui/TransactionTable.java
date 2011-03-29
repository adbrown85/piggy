package piggy.gui;

import java.util.List;
import javax.swing.JTable;
import piggy.data.Transaction;


/**
 * Table of transactions.
 */
public class TransactionTable extends JTable {
    
    /**
     * Creates a transaction table.
     */
    TransactionTable() {
        super(new TransactionTableModel());
    }
    
    /**
     * Adds transactions to the table.
     * 
     * @param transactions
     */
    void add(List<Transaction> transactions) {
        getModel().add(transactions);
    }
    
    //--------------------------------------------------
    // Getters
    //
    
    /** Returns the table's model. */
    @Override
    public TransactionTableModel getModel() {
        return (TransactionTableModel) super.getModel();
    }
}
