package Controller;

import View.DrawPanel;
import View.Rectangle;
import Model.*;
import javax.swing.event.MouseInputListener;
import java.awt.event.MouseEvent;

/**
 * RectangleController controls the creating and modification of the rectangle to draw classes.
 * RectangleController realizes from MouseInputListener.
 * @author Haritej Lakshmi Narayan, Chris Lazar, Sunayana Gupta, Rahul Kumar, Cameron Woehler, Bhavana Priya Kanumur
 */
public class RectangleController implements MouseInputListener {

    Rectangle rectangle;

    RectangleModel rectangleModel;

    int preX, preY;

    boolean pressOut = false;

    DrawPanel drawPanel;

    /**
     * Constructor for RectangleController
     * @param rectangle
     * @param model
     * @param drawPanel
     */
    public RectangleController(Rectangle rectangle, RectangleModel model, DrawPanel drawPanel){

        this.rectangle = rectangle;
        this.rectangleModel = model;
        this.drawPanel = drawPanel;
        this.rectangle.addMouseListener(this);
    }

    /**
     * get preX
     * @return
     */
    public int getPreX() {
        return preX;
    }

    /**
     * set preX
     * @return
     */
    public void setPreX(int preX) {
        this.preX = preX;
    }

    /**
     * get preY
     * @return
     */
    public int getPreY() {
        return preY;
    }

    /**
     * set preX
     * @return
     */
    public void setPreY(int preY) {
        this.preY = preY;
    }

    /**
     * get pressOut
     * @return
     */
    public boolean isPressOut() {
        return pressOut;
    }

    /**
     * set pressOut
     * @return
     */
    public void setPressOut(boolean pressOut) {
        this.pressOut = pressOut;
    }

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

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Clicked on a box");
        clickEmulator();
    }

    public void clickEmulator() {
        drawPanel.boxClickTracker(rectangle);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        setPreX(rectangleModel.getxPos()- e.getX());
        setPreY(rectangleModel.getyPos() - e.getY());
        moved(getPreX()+ e.getX(), getPreY()+ e.getY());
        rectangle.repaint();
        drawPanel.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        moved(getPreX()+ e.getX(), getPreY()+ e.getY());
        rectangle.repaint();
        drawPanel.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(!isPressOut()){
            moved(getPreX()+ e.getX(), getPreY()+ e.getY());
            rectangle.repaint();
            drawPanel.repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
