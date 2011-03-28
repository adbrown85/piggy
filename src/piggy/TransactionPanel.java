package piggy;

import java.io.File;
import java.io.FileNotFoundException;
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
        model.add(TransactionParser.parse(file));
    }
}
