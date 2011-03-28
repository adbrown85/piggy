package piggy.gui;

import java.io.File;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.junit.Test;
import piggy.gui.TransactionPanel;


public class TransactionPanelTest {
    
    @Test
    public void testShow() throws Exception {
        
        final JFrame frame = new JFrame();
        final TransactionPanel tp = new TransactionPanel();
        final File file = new File("test/sample.qif");
        
        tp.load(file);
        frame.add(tp);
        frame.pack();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.setVisible(true);
            }
        });
        synchronized (frame) {
            frame.wait();
        }
    }
}
