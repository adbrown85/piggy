package piggy.gui;

import java.io.File;
import javax.swing.JFrame;
import org.jtesttools.JTestFrame;
import org.junit.Test;
import piggy.gui.TransactionPanel;


public class TransactionPanelTest {
    
    @Test
    public void testShow() throws Exception {
        
        final JFrame frame = new JTestFrame();
        final TransactionPanel tp = new TransactionPanel();
        final File file = new File("test/sample.qif");
        
        tp.load(file);
        frame.add(tp);
        frame.pack();
        JTestFrame.run(frame);
    }
}
