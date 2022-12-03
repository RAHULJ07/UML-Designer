package View;

import Controller.DrawPanelController;
import Model.Storage;
import View.DrawPanel;

import java.awt.Color;

import javax.swing.JLayeredPane;

public class AppPanel extends JLayeredPane{

    DrawPanel drawPanel;
    TextPanel textPanel;

    public AppPanel(){
        setBounds(0,0,1000,1000);
        addPanels();
    }

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

    public DrawPanel getDrawPanel() {
        return drawPanel;
    }

    public TextPanel getTextPanel() {
        return textPanel;
    }
}
