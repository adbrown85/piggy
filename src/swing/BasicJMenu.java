package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JMenu;
import javax.swing.JMenuItem;


public class BasicJMenu extends JMenu implements ActionListener {
    
    private final List<ActionListener> listeners;
    
    public BasicJMenu(String title) {
        super(title);
        listeners = new ArrayList<ActionListener>();
    }
    
    protected void addMenuItem(JMenuItem item) {
        add(item);
        item.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        for (ActionListener al : listeners) {
            al.actionPerformed(ae);
        }
    }
    
    @Override
    public void addActionListener(ActionListener al) {
        super.addActionListener(al);
        listeners.add(al);
    }
}
