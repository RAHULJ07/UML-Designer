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
    }


    public void boxClickTracker(Rectangle rectangle) {
        rectanglesClicked.add(rectangle);
        drawPanel.repaint();
    }

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        Line line;
        InheritanceArrow inheritanceArrow;
        CompositionArrow compositionArrow;
        AggregationArrow aggregationArrow;


        LineCoordinates coordinate;
        if (rectanglesClicked.size() == 2) {
            coordinate = new LineCoordinates(rectanglesClicked.get(0).getX(),rectanglesClicked.get(0).getY(),
                    rectanglesClicked.get(1).getX(), rectanglesClicked.get(1).getY(), ArrowType.getArrowType());
            Storage.getInstance().addLineCoordinate(coordinate);
            rectanglesClicked.clear();
        }
        if(Storage.getInstance().getCoordinates().size()>0) {
            for (LineCoordinates coord : Storage.getInstance().getCoordinates()) {
                aType = coord.getArrowType();
                line = new Line(coord);
                if (aType.equals("Composition")) {
                    compositionArrow = new CompositionArrow(coord);
                    compositionArrow.add(line);
                    compositionArrow.draw(g2);

                } else if (aType.equals("Aggregation")) {
                    aggregationArrow = new AggregationArrow(coord);
                    aggregationArrow.add(line);
                    aggregationArrow.draw(g2);


                } else if (aType.equals("Inheritance")) {
                    inheritanceArrow = new InheritanceArrow(coord);
                    inheritanceArrow.add(line);
                    inheritanceArrow.draw(g2);


                }
            }
        }
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
            Rectangle newRectangle = new Rectangle(x, y, className, drawPanel);
            Storage.getInstance().addRectangle(newRectangle);
            drawPanel.add(newRectangle);
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
