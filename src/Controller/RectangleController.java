package Controller;

import View.Rectangle;
import Model.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;

public class RectangleController implements MouseInputListener {

    Rectangle rectangle;

    public RectangleController(Rectangle rectangle){
        this.rectangle = rectangle;
    }

    public void moved(int x, int y){
        for( LineCoordinates coord : Storage.getInstance().getCoordinates()){
            if((coord.getStartX()== rectangle.getxPos()) && (coord.getStartY()== rectangle.getyPos()))
            {
                coord.setStartX(x);
                coord.setStartY(y);
            }
            else if((coord.getEndX()== rectangle.getxPos()) && (coord.getEndY()== rectangle.getyPos())){
                coord.setEndX(x);
                coord.setEndY(y);
            }
        }
        rectangle.setxPos(x);
        rectangle.setyPos(y);
        rectangle.setLocation(x, y);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Clicked on a box");
        clickEmulator();
    }

    public void clickEmulator() {
        rectangle.getDrawPanel().getDrawPanelController().boxClickTracker(rectangle);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        rectangle.setPreX(rectangle.getxPos()- e.getX());
        rectangle.setPreY(rectangle.getyPos() - e.getY());
        moved(rectangle.getPreX()+ e.getX(), rectangle.getPreY()+ e.getY());
        rectangle.repaint();
        rectangle.getDrawPanel().repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        moved(rectangle.getPreX()+ e.getX(), rectangle.getPreY()+ e.getY());
        rectangle.repaint();
        rectangle.getDrawPanel().repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(!rectangle.isPressOut()){
            moved(rectangle.getPreX()+ e.getX(), rectangle.getPreY()+ e.getY());
            rectangle.repaint();
            rectangle.getDrawPanel().repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
