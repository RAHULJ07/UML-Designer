import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TextPanel extends Observer {

    private static TextPanel textPanel;
    protected JPanel tPanel;
    private static StringBuilder code;
    private static JTextArea textArea;
    private TextPanel(){
        tPanel = new JPanel();
        textArea = new JTextArea();
        textArea.setSize(500, 1000);
        textArea.setBackground(Color.LIGHT_GRAY);
        tPanel.add(textArea);
        code=new StringBuilder();
    }

    public static TextPanel getTextPanel(){
        if(textPanel==null){
            textPanel= new TextPanel();
        }
        return textPanel;
    }
    
    @Override
    public void update(String classname){
        code.append("\n"+classname);
        textArea.setText(code.toString());
        StatusBar.getStatus().setStatus(String.format("Creating class: %s", classname));
    }
}
