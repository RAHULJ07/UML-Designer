package Controller;

import Model.*;
import View.*;
import View.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class DrawPanelController implements MouseListener, MouseMotionListener {

    DrawPanel drawPanel;

    private ArrayList<Rectangle> rectanglesClicked;
    private String aType;

    public DrawPanelController(DrawPanel drawPanel){
        this.drawPanel = drawPanel;
        rectanglesClicked = new ArrayList<>();
        this.drawPanel.addMouseListener(this);
    }

    public DrawPanel getDrawPanel() {
        return drawPanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        rectanglesClicked.clear();
        int x = e.getX();
        int y = e.getY();
        String className = JOptionPane.showInputDialog("Enter class name");
        if ((className != null)) {
            if (className.length() == 0) {
                className = "Enter class name";
            }
            RectangleModel rectangleModel = new RectangleModel(x, y, className);
            Rectangle rect = new Rectangle(rectangleModel);
            RectangleController rectangleController = new RectangleController(rect, rectangleModel, drawPanel);
            Storage.getInstance().addRectangle(rectangleModel);
            drawPanel.add(rect);
            drawPanel.repaint();
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
