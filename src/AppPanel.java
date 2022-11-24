import java.awt.Color;

import javax.swing.JLayeredPane;

public class AppPanel extends JLayeredPane{
    static protected AppPanel appPanel;
    private AppPanel(){
        setBounds(0,0,1000,1000);
        addPanels();
    }

    public static AppPanel getAppPanel(){
        if(appPanel==null)
            appPanel= new AppPanel();
        return appPanel;
    }

    public void addPanels(){
        DrawPanel drawPanel = DrawPanel.getDrawPanel();
        drawPanel.setBounds(500,0,500,1000);
        drawPanel.setBackground(Color.getHSBColor(184, 172, 232));
        add(drawPanel);
        TextPanel textPanel = TextPanel.getTextPanel();
        textPanel.tPanel.setBounds(0,0,500,1000);
        add(textPanel.tPanel);
        drawPanel.addObserver(textPanel);
    }
}
