package View;

import javax.swing.*;
import java.awt.*;

public class MenuView extends JFrame {

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

    public MenuView(){
        fileMenu.add(newButton);
        fileMenu.add(saveButton);
        fileMenu.add(loadButton);
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        group.add(composition);
        relationship.add(composition);
        group.add(aggregation);
        relationship.add(aggregation);
        group.add(inheritance);
        relationship.add(inheritance);
        menuBar.add(relationship);
        setJMenuBar(menuBar);
        setSize(1000, 1000);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JMenuItem getNewButton() {
        return newButton;
    }

    public JMenuItem getSaveButton() {
        return saveButton;
    }

    public JMenuItem getLoadButton() {
        return loadButton;
    }

    public JRadioButtonMenuItem getComposition() {
        return composition;
    }

    public JRadioButtonMenuItem getAggregation() {
        return aggregation;
    }

    public JRadioButtonMenuItem getInheritance() {
        return inheritance;
    }
}
