package piggy.gui;

import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import piggy.data.TransactionParser;
import swing.VerticalBox;


/**
 * Panel for holding the transactions.
 */
public class TransactionPanel extends VerticalBox {
    
    TransactionTableModel model = new TransactionTableModel();
    JTable table = new JTable(model);
    JScrollPane pane = new JScrollPane(table);
    
    TransactionPanel() {
        add(pane);
    }
    
    void load(File file) throws FileNotFoundException {
        model.add(TransactionParser.parse(file));
    }
}
