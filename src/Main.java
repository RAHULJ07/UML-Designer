import Controller.Controller;
import View.AppPanel;
import View.StatusBar;

import java.awt.BorderLayout;
import javax.swing.*;

public class Main extends JFrame{
    AppPanel appPanel;
    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("File");
    JMenu helpMenu = new JMenu("Help");
    JMenu relationship = new JMenu("Relationship");
    JMenuItem newButton = new JMenuItem("New");
    JMenuItem saveButton = new JMenuItem("Save");
    JMenuItem loadButton = new JMenuItem("Load");

    JRadioButtonMenuItem composition = new JRadioButtonMenuItem("Composition");
    JRadioButtonMenuItem aggregation = new JRadioButtonMenuItem("Aggregation");
    JRadioButtonMenuItem inheritance = new JRadioButtonMenuItem("Inheritance");
    ButtonGroup group = new ButtonGroup();

    static StatusBar status = StatusBar.getStatus();

    Controller controller;


    public Main(){
        controller = new Controller();
        appPanel = new AppPanel();
        setLayout(new BorderLayout(3, 2));
        getContentPane().add(appPanel);
        getContentPane().add(status, java.awt.BorderLayout.SOUTH);
        fileMenu.add(newButton);
        fileMenu.add(saveButton);
        fileMenu.add(loadButton);
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        newButton.addActionListener(controller);
        saveButton.addActionListener(controller);
        loadButton.addActionListener(controller);
        group.add(composition);
        relationship.add(composition);
        group.add(aggregation);
        relationship.add(aggregation);
        group.add(inheritance);
        relationship.add(inheritance);
        composition.addActionListener(controller);
        aggregation.addActionListener(controller);
        inheritance.addActionListener(controller);
        menuBar.add(relationship);
        setJMenuBar(menuBar);
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        JFrame main = new Main();
    }

}
