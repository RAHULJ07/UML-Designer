package Controller;

import View.DrawPanel;
import View.Rectangle;
import Model.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Controller for rectangle box created on class creation. RectangleController realizes the MouseInputListener
 * @author Haritej Lakshmi Narayan, Chris Lazar, Sunayana Gupta, Rahul Kumar, Cameron Woehler, Bhavana Priya Kanumuri
 */
public class RectangleController implements MouseInputListener {

    Rectangle rectangle;
    RectangleModel rectangleModel;
    int preX, preY;
    boolean pressOut = false;
    DrawPanel drawPanel;

    /**
     * Initializes the rectangle class with the draw panel
     * @param rectangle box created on class creation
     * @param model model of the box created on class creation
     * @param drawPanel panel created on creation of application panel
     */
    public RectangleController(Rectangle rectangle, RectangleModel model, DrawPanel drawPanel){

        this.rectangle = rectangle;
        this.rectangleModel = model;
        this.drawPanel = drawPanel;
        this.rectangle.addMouseListener(this);
    }

    /**
     * Getter method that gets the x-coordinate of the rectangle
     * @return x-coordinate
     */
    public int getPreX() {
        return preX;
    }

    /**
     * Setter method that sets the x-coordinate of the rectangle
     * @param preX x-coordinate
     */
    public void setPreX(int preX) {
        this.preX = preX;
    }

    /**
     * getter method that gets the y co-ordinate of the rectangle
     * @return y co-ordinate
     */
    public int getPreY() {
        return preY;
    }

    /**
     * setter methods that sets the y co-ordinate of the rectangle
     * @param preY y co-ordinate
     */
    public void setPreY(int preY) {
        this.preY = preY;
    }

    /**
     * @return boolean value that returns true or false
     */
    public boolean isPressOut() {
        return pressOut;
    }

    /**
     * setter method that sets/toggles the pressOut button
     * @param pressOut boolean value that returns true or false
     */
    public void setPressOut(boolean pressOut) {
        this.pressOut = pressOut;
    }

    /**
     * gets and sets the new x and y coordinates of the rectangle when it is moved/dragged from one position to another
     * @param x x coordinate
     * @param y y coordinate
     */
    public void moved(int x, int y){
        for( LineCoordinates coord : Storage.getInstance().getCoordinates()){
            if((coord.getStartX()== rectangleModel.getxPos()) && (coord.getStartY()== rectangleModel.getyPos()))
            {
                coord.setStartX(x);
                coord.setStartY(y);
            }
            else if((coord.getEndX()== rectangleModel.getxPos()) && (coord.getEndY()== rectangleModel.getyPos())){
                coord.setEndX(x);
                coord.setEndY(y);
            }
        }
        rectangleModel.setxPos(x);
        rectangleModel.setyPos(y);
        rectangle.setLocation(x, y);
    }

    /**
     * mouse click event when a rectangle 'class' is clicked
     * @param e mouse click
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Clicked on a box");
        clickEmulator();
    }

    /**
     * tracks which rectangle was selected
     */
    public void clickEmulator() {
        drawPanel.boxClickTracker(rectangle);
    }

    /**
     * Mouse pressed event that gets and sets the x and y coordinates of rectangle when the mouse press is started
     * @param e mouse pressed event
     */
    @Override
    public void mousePressed(MouseEvent e) {
        setPreX(rectangleModel.getxPos()- e.getX());
        setPreY(rectangleModel.getyPos() - e.getY());
        moved(getPreX()+ e.getX(), getPreY()+ e.getY());
        rectangle.repaint();
        drawPanel.repaint();
    }

    /**
     * mouse released event that gets the x and y coordinates of the rectangle when the mouse release is performed
     * @param e mouse released event
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        moved(getPreX()+ e.getX(), getPreY()+ e.getY());
        rectangle.repaint();
        drawPanel.repaint();
    }

    /**
     * @param e mouse entered event
     */
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    /**
     * @param e mouse exited event
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }

    /**
     * mouse dragged event that gets the coordinates of the rectangle moved
     * @param e mouse event
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        if(!isPressOut()){
            moved(getPreX()+ e.getX(), getPreY()+ e.getY());
            rectangle.repaint();
            drawPanel.repaint();
        }
    }

    /**
     * @param e mouse moved event
     */
    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
