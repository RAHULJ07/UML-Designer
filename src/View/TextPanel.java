package View;

import java.awt.Color;
import java.util.*;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import Model.LineCoordinates;
import Model.RectangleModel;
import Model.Storage;

/**
 * TextPanel inherits from Observer. TextPanel observer the DrawPanel, to create the class text in the text panel
 * TextPanel is also a singleton class.
 * @author Haritej Lakshmi Narayan, Chris Lazar, Sunayana Gupta, Rahul Kumar, Cameron Woehler, Bhavana Priya Kanumuri
 */
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

    /**
     * getter method to get the instance of text panel from the application panel, if it exists or it creates a new instance
     * @return instance of text panel
     */
    public static TextPanel getTextPanel(){
        if(textPanel==null){
            textPanel= new TextPanel();
        }
        return textPanel;
    }

    /**
     * updates the text according to changes observed in the draw panel (observable).
     * text area returns the class name of the rectangle class created in draw panel.
     */
    
    @Override
    public void update(){
        code= new StringBuilder();
        Storage storage = Storage.getInstance();
        for(RectangleModel rectangle: storage.getRectangles()){
            code.append("class " + rectangle.getClassName());
            List<String> inheritanceClasses = new ArrayList<String>();
            List<String> associationClasses = new ArrayList<String>();
            List<String> compositionClasses = new ArrayList<String>();
            for(LineCoordinates arrow : storage.getCoordinates()){
                if(arrow.getArrowType().equals("Inheritance") && (arrow.getStartX()==rectangle.getxPos() && arrow.getStartY()==rectangle.getyPos())){
                    inheritanceClasses.add(storage.getRectangleAt(arrow.getEndX(), arrow.getEndY()));
                }
                else if(arrow.getArrowType().equals("Association") && (arrow.getStartX()==rectangle.getxPos() && arrow.getStartY()==rectangle.getyPos())){
                    associationClasses.add(storage.getRectangleAt(arrow.getEndX(), arrow.getEndY()));
                }
                else if(arrow.getArrowType().equals("Composition") && (arrow.getStartX()==rectangle.getxPos() && arrow.getStartY()==rectangle.getyPos())){
                    compositionClasses.add(storage.getRectangleAt(arrow.getEndX(), arrow.getEndY()));
                }
            }
            if(inheritanceClasses.size()!=0){
                code.append(" extends ");
                for(String str : inheritanceClasses){
                    code.append(str + ",");
                }
            }
            code.append("{"+ System.lineSeparator());
            for(String str : compositionClasses){
                code.append(str + System.lineSeparator());
            }
            if(associationClasses.size()!=0)
            {
                code.append("method() { " + System.lineSeparator());
                for(String str : associationClasses){
                    code.append(str + System.lineSeparator());
                }
                code.append("}" + System.lineSeparator());
            }
            code.append("}"+ System.lineSeparator());   
        }
        //code.append("\n"+classname);
        textArea.setText(code.toString());
    }
}
