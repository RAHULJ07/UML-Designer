import java.awt.Color;

import javax.swing.JLayeredPane;

public class AppPanel extends JLayeredPane{


    public AppPanel(){
        setBounds(0,0,1000,1000);
        addPanels();
    }

    public void addPanels(){
        DrawPanel drawPanel = new DrawPanel();
        drawPanel.setBounds(500,0,500,1000);
        drawPanel.setBackground(Color.getHSBColor(184, 172, 232));
        add(drawPanel);
        TextPanel textPanel = TextPanel.getTextPanel();
        textPanel.tPanel.setBounds(0,0,500,1000);
        add(textPanel.tPanel);
        drawPanel.addObserver(textPanel);
    }
}
