package piggy.gui;

import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JScrollPane;
import piggy.data.TransactionParser;
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
        table.add(TransactionParser.parse(file));
    }
}
