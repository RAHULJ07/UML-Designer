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

/**
 * DrawPanelController controls the creating and modification of the draw panel to draw classes and relationships between them.
 * DrawPanel realizes from MouseListener and MouseMotionListener.
 * @author Haritej Lakshmi Narayan, Chris Lazar, Sunayana Gupta, Rahul Kumar, Cameron Woehler, Bhavana Priya Kanumur
 */
public class DrawPanelController implements MouseListener, MouseMotionListener {

    DrawPanel drawPanel;

    private ArrayList<Rectangle> rectanglesClicked;
    private String aType;

    /**
     * Initializes the DrawPanel and stores the selected classes in an arraylist
     * @param drawPanel
     */
    public DrawPanelController(DrawPanel drawPanel){
        this.drawPanel = drawPanel;
        rectanglesClicked = new ArrayList<>();
        this.drawPanel.addMouseListener(this);
    }

    /**
     * Getter method that gets the draw panel
     * @return the draw panel where the class diagram is drawn/represented
     */
    public DrawPanel getDrawPanel() {
        return drawPanel;
    }

    /**
     * Opens a dialog box when clicked on the Draw Panel to input class name with the help of RectangleController
     * @param e mouse-click event
     */
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
            Storage.getInstance().loadRectangle(rectangleModel);
            drawPanel.add(rect);
            drawPanel.repaint();
        }

    }

    /**
     * Mouse Pressed event
     * @param e event corresponding to mouse press
     */
    @Override
    public void mousePressed(MouseEvent e) {

    }

    /**
     * Mouse Released event
     * @param e event corresponding to mouse release
     */
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * Mouse Entered event
     * @param e event corresponding to mouse entered
     */
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    /**
     * Mouse Exited event
     * @param e event corresponding to mouse exited
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }

    /**
     * Mouse Dragged event
     * @param e event corresponding to mouse dragged
     */
    @Override
    public void mouseDragged(MouseEvent e) {

    }

    /**
     * Mouse Moved event
     * @param e event corresponding to mouse moved
     */
    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
