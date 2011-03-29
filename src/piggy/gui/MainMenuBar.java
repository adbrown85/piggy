package piggy.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import swing.BasicJMenu;


public class MainMenuBar extends JMenuBar implements ActionListener {
    
    private final List<ActionListener> listeners;
    
    public MainMenuBar() {
        listeners = new ArrayList<ActionListener>();
        addMenu(new FileMenu());
    }
    
    protected void addMenu(JMenu menu) {
        add(menu);
        menu.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        for (ActionListener al : listeners) {
            al.actionPerformed(ae);
        }
    }
    
    public void addActionListener(ActionListener al) {
        listeners.add(al);
    }
}


class FileMenu extends BasicJMenu {
    
    FileMenu() {
        super("File");
        
        addMenuItem(new JMenuItem("Open"));
        addMenuItem(new JMenuItem("Save"));
    }
}
