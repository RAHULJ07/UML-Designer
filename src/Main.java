import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener{
    static AppPanel appPanel = AppPanel.getAppPanel();
    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("File");
    JMenu helpMenu = new JMenu("Help");
    JMenuItem newButton = new JMenuItem("New");
    JMenuItem saveButton = new JMenuItem("Save");
    JMenuItem loadButton = new JMenuItem("Load");
    static StatusBar status = StatusBar.getStatus();
    public Main(){
        setLayout(new BorderLayout(3, 2));
        getContentPane().add(appPanel);
        getContentPane().add(status, java.awt.BorderLayout.SOUTH);
        fileMenu.add(newButton);
        fileMenu.add(saveButton);
        fileMenu.add(loadButton);
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        JFrame main = new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        
    }
}
