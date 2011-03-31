package piggy.gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import javax.swing.JScrollPane;
import piggy.data.Transaction;
import piggy.data.TransactionParser;
import piggy.data.TransactionReporter;
import swing.VerticalBox;


/**
 * Panel for holding the transactions.
 */
public class TransactionPanel extends VerticalBox {
    
    TransactionTable table = new TransactionTable();
    JScrollPane pane = new JScrollPane(table);
    
    public TransactionPanel() {
        add(pane);
    }
    
    public void load(File file) throws FileNotFoundException {
        table.clear();
        table.add(TransactionParser.parse(file));
    }
    
    public void save(File file) {
        TransactionReporter.report(file, getTransactions());
    }
    
    //------------------------------------------------------------
    // Helpers
    //
    
    private List<Transaction> getTransactions() {
        return table.getTransactions();
    }
}
