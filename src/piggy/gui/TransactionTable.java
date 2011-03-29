package piggy.gui;

import java.awt.Dimension;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import piggy.data.Transaction;


/**
 * Table of transactions.
 */
public class TransactionTable extends JTable {
    
    private static final int DEFAULT_VIEWPORT_WIDTH = 800;
    private static final int DEFAULT_VIEWPORT_HEIGHT = 400;
    private static final int DEFAULT_DATE_WIDTH = 50;
    private static final int DEFAULT_AMOUNT_WIDTH = 70;
    private static final int DEFAULT_CATEGORY_WIDTH = 80;
    private static final int DEFAULT_DESCRIPTION_WIDTH = 600;
    
    /**
     * Creates a transaction table.
     */
    TransactionTable() {
        super(new TransactionTableModel());
        
        initColumnWidths();
        initColumnEditors();
        
        setFillsViewportHeight(true);
        setPreferredScrollableViewportSize(getDefaultViewportSize());
        setAutoResizeMode(AUTO_RESIZE_LAST_COLUMN);
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
    
    private void initColumnEditors() {
        
        TableColumnModel tcm = getColumnModel();
        TableColumn tc = tcm.getColumn(2);
        JComboBox cb = new JComboBox();
        
        cb.addItem("Income");
        cb.addItem("Food");
        cb.addItem("Rent");
        cb.addItem("Other");
        tc.setCellEditor(new DefaultCellEditor(cb));
    }
    
    //--------------------------------------------------
    // Getters
    //
    
    /** Returns default size of viewport when added to a scroll pane. */
    private static Dimension getDefaultViewportSize() {
        return new Dimension(DEFAULT_VIEWPORT_WIDTH, DEFAULT_VIEWPORT_HEIGHT);
    }
    
    /** Returns preferred width for a column. */
    private int getPreferredColumnWidth(int index) {
        switch (index) {
        case 0: return DEFAULT_DATE_WIDTH;
        case 1: return DEFAULT_AMOUNT_WIDTH;
        case 2: return DEFAULT_CATEGORY_WIDTH;
        case 3: return DEFAULT_DESCRIPTION_WIDTH;
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
