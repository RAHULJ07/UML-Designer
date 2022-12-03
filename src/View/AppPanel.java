package View;

import Controller.DrawPanelController;
import Model.Storage;
import View.DrawPanel;

import java.awt.Color;

import javax.swing.JLayeredPane;

/**
 * View of the Application Panel. It inherits from JLayeredPane.
 * @author Haritej Lakshmi Narayan, Chris Lazar, Sunayana Gupta, Rahul Kumar, Cameron Woehler, Bhavana Priya Kanumuri
 */
public class AppPanel extends JLayeredPane{

    DrawPanel drawPanel;
    TextPanel textPanel;

    public AppPanel(){
        setBounds(0,0,1000,1000);
        addPanels();
    }
    /**
     * adds panels to the basic application panel - text panel and draw panel added.
     */
    public void addPanels(){
        drawPanel = new DrawPanel();
        drawPanel.setBounds(500,0,500,1000);
        drawPanel.setBackground(Color.getHSBColor(184, 172, 232));
        add(drawPanel);
        textPanel = TextPanel.getTextPanel();
        textPanel.tPanel.setBounds(0,0,500,1000);
        add(textPanel.tPanel);
        Storage.getInstance().addObserver(textPanel);
    }

    /**
     * getter method to get the draw panel
     * @return draw panel
     */
    public DrawPanel getDrawPanel() {
        return drawPanel;
    }

    /**
     * getter method to get the text panel
     * @return text panel
     */
    public TextPanel getTextPanel() {
        return textPanel;
    }
}
