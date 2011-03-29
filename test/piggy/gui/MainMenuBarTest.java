package piggy.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jtesttools.JTestFrame;
import org.junit.Test;


public class MainMenuBarTest {
    
    @Test
    public void testAdd() {
        
        JFrame frame = new JTestFrame();
        MainMenuBar mmb = new MainMenuBar();
        JPanel panel = new JPanel();
        
        panel.setPreferredSize(new Dimension(512, 512));
        mmb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.err.println(e.getActionCommand());
            }
        });
        
        frame.setJMenuBar(mmb);
        frame.add(panel);
        JTestFrame.run(frame);
    }
}
