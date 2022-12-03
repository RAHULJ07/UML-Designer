import Controller.*;
import View.StatusBar;
import java.awt.BorderLayout;
import javax.swing.*;

/**
 * Main class that sets up and launches the GUI application.
 * @author Haritej Lakshmi Narayan, Chris Lazar, Sunayana Gupta, Rahul Kumar, Cameron Woehler, Bhavana Priya Kanumuri
 */
public class Main extends JFrame{
    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("File");
    JMenu helpMenu = new JMenu("Help");
    JMenu relationship = new JMenu("Relationship");
    JMenuItem newButton = new JMenuItem("New");
    JMenuItem saveButton = new JMenuItem("Save");
    JMenuItem loadButton = new JMenuItem("Load");
    JLabel mem1 = new JLabel("Bhavana Priya");
    JLabel mem2 = new JLabel("Cameron Woehler");
    JLabel mem3 = new JLabel("Chris Lazar");
    JLabel mem4 = new JLabel("Haritej Lakshmi Narayan");
    JLabel mem5 = new JLabel("Rahul Kumar");
    JLabel mem6 = new JLabel("Sunayana Gupta"); 
    JRadioButtonMenuItem composition = new JRadioButtonMenuItem("Composition");
    JRadioButtonMenuItem association = new JRadioButtonMenuItem("Association");
    JRadioButtonMenuItem inheritance = new JRadioButtonMenuItem("Inheritance");
    ButtonGroup group = new ButtonGroup();
    static StatusBar status = StatusBar.getStatus();

    /**
     * Gets an instance of the main controller and draws the GUI application
     */
    public Main(){
        MainController mainController = MainController.getInstance();
        setLayout(new BorderLayout(3, 2));
        getContentPane().add(mainController.getAppPanelController().getAppPanel());
        getContentPane().add(status, java.awt.BorderLayout.SOUTH);
        fileMenu.add(newButton);
        fileMenu.add(saveButton);
        fileMenu.add(loadButton);
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        helpMenu.add(mem1);
        helpMenu.add(mem2);
        helpMenu.add(mem3);
        helpMenu.add(mem4);
        helpMenu.add(mem5);
        helpMenu.add(mem6);
        newButton.addActionListener(mainController);
        saveButton.addActionListener(mainController);
        loadButton.addActionListener(mainController);
        group.add(composition);
        relationship.add(composition);
        group.add(association);
        relationship.add(association);
        group.add(inheritance);
        relationship.add(inheritance);
        composition.addActionListener(mainController);
        composition.setSelected(true);
        ArrowType.setArrowType("Composition");
        association.addActionListener(mainController);
        inheritance.addActionListener(mainController);
        menuBar.add(relationship);
        setJMenuBar(menuBar);
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * @param args string of arguments
     */
    public static void main(String[] args) {
        JFrame main = new Main();
    }

}
