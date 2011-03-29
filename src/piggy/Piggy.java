package piggy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import piggy.gui.MainMenuBar;
import piggy.gui.TransactionPanel;


public class Piggy implements Runnable, ActionListener {
    
    private static final String TITLE = "Piggy";
    
    private final JFrame frame;
    private final MainMenuBar mainMenuBar;
    private final TransactionPanel transactionPanel;
    private final JFileChooser fileChooser;
    
    Piggy() {
        frame = new JFrame(TITLE);
        mainMenuBar = new MainMenuBar();
        transactionPanel = new TransactionPanel();
        fileChooser = new JFileChooser();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String ac = e.getActionCommand();
        
        if (ac.equals("Open")) {
            onOpen();
        } else if (ac.equals("Save")) {
            onSave();
        }
    }
    
    /**
     * Shows the window.
     */
    @Override
    public void run() {
        mainMenuBar.addActionListener(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(mainMenuBar);
        frame.add(transactionPanel);
        frame.pack();
        frame.setVisible(true);
    }
    
    //------------------------------------------------------------
    // Helpers
    //
    
    private void onOpen() {
        
        int code = fileChooser.showOpenDialog(transactionPanel);
        File file;
        
        if (code == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            try {
                transactionPanel.load(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException("File from chooser not found!");
            }
        }
    }
    
    private void onSave() {
        
        int code = fileChooser.showSaveDialog(transactionPanel);
        File file;
        
        if (code == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            transactionPanel.save(file);
        }
    }
    
    //------------------------------------------------------------
    // Main
    //
    
    /**
     * Runs the application.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Piggy());
    }
}
