package View;

import Controller.*;
import Model.LineCoordinates;
import Model.Storage;
import org.w3c.dom.css.Rect;

import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;

/**
 * View for DrawPanel. It inherits from the JPanel class.
 * @author Haritej Lakshmi Narayan, Chris Lazar, Sunayana Gupta, Rahul Kumar, Cameron Woehler, Bhavana Priya Kanumuri
 */
public class DrawPanel extends JPanel {

    private ArrayList<View.Rectangle> rectanglesClicked;
    private String aType;

    public DrawPanel(){
        rectanglesClicked = new ArrayList<>();
        setLayout(null);
    }

    /**
     * tracks the number of boxes clicked
     * @param rectangle the class created
     */
    public void boxClickTracker(Rectangle rectangle) {
        rectanglesClicked.add(rectangle);
        this.repaint();
    }

    /**
     * draws the rectangle classes and the relationships between them
     * @param g graphics component
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Line line;
        InheritanceArrow inheritanceArrow;
        CompositionArrow compositionArrow;
        AssociationArrow associationArrow;

        LineCoordinates coordinate;

        String[] rectClasses = new String[2];

        if (rectanglesClicked.size() == 2) {
            coordinate = new LineCoordinates(rectanglesClicked.get(0).getX(),rectanglesClicked.get(0).getY(),
                    rectanglesClicked.get(1).getX(), rectanglesClicked.get(1).getY(), ArrowType.getArrowType());
            Storage.getInstance().addLineCoordinate(coordinate);

            rectClasses[0] = rectanglesClicked.get(0).rectClassName;
            rectClasses[1] = rectanglesClicked.get(1).rectClassName;

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

                    if (rectClasses[0] != null) {
                        StatusBar.getStatus().setStatus(String.format("Drawing Composition from %s to %s.", rectClasses[0], rectClasses[1]));
                    }

                } else if (aType.equals("Association")) {
                    associationArrow = new AssociationArrow(coord);
                    associationArrow.add(line);
                    associationArrow.draw(g2);

                    if (rectClasses[0] != null) {
                        StatusBar.getStatus().setStatus(String.format("Drawing Association from %s to %s.", rectClasses[0], rectClasses[1]));
                    }


                } else if (aType.equals("Inheritance")) {
                    inheritanceArrow = new InheritanceArrow(coord);
                    inheritanceArrow.add(line);
                    inheritanceArrow.draw(g2);

                    if (rectClasses[0] != null) {
                        StatusBar.getStatus().setStatus(String.format("Drawing Inheritance from %s to %s.", rectClasses[0], rectClasses[1]));
                    }
                }
            }
        }
    }

}
