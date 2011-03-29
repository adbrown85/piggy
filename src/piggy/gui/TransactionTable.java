package piggy.gui;

import java.util.List;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import piggy.data.Transaction;


/**
 * Table of transactions.
 */
public class TransactionTable extends JTable {
    
    private static final int DATE_WIDTH = 20;
    private static final int AMOUNT_WIDTH = 40;
    private static final int CATEGORY_WIDTH = 40;
    private static final int DESCRIPTION_WIDTH = 200;
    
    /**
     * Creates a transaction table.
     */
    TransactionTable() {
        super(new TransactionTableModel());
        
        initColumnWidths();
    }
    
    /**
     * Adds transactions to the table.
     * 
     * @param transactions List of transactions to add
     */
    void add(List<Transaction> transactions) {
        getModel().add(transactions);
    }
    
    //--------------------------------------------------
    // Helpers
    //
    
    /**
     * Initializes column widths.
     */
    private void initColumnWidths() {
        
        TableColumnModel tcm = getColumnModel();
        TableColumn tc;
        
        for (int i=0; i<4; ++i) {
            tc = tcm.getColumn(i);
            tc.setPreferredWidth(getPreferredColumnWidth(i));
        }
    }
    
    //--------------------------------------------------
    // Getters
    //
    
    /** Returns preferred width for a column. */
    private int getPreferredColumnWidth(int index) {
        switch (index) {
        case 0: return DATE_WIDTH;
        case 1: return AMOUNT_WIDTH;
        case 2: return CATEGORY_WIDTH;
        case 3: return DESCRIPTION_WIDTH;
        default:
            throw new RuntimeException("Unexpected column index!");
        }
    }
    
    /** Returns the table's model. */
    @Override
    public TransactionTableModel getModel() {
        return (TransactionTableModel) super.getModel();
    }
}
