package View;

import Controller.ArrowType;
import Controller.DrawPanelController;
import Model.Storage;
import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;

public class DrawPanel extends JPanel {

    private ArrayList<View.Rectangle> rectanglesClicked;
    private String aType;

    DrawPanelController drawPanelController;

    public DrawPanel(){
        drawPanelController = new DrawPanelController(this);
        rectanglesClicked = new ArrayList<>();
        setLayout(null);
        addMouseListener(drawPanelController);
    }

    public DrawPanelController getDrawPanelController() {
        return drawPanelController;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawPanelController.paintComponent(g);
    }

}
