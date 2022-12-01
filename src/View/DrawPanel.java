package View;

import Controller.*;
import Model.LineCoordinates;
import Model.Storage;
import org.w3c.dom.css.Rect;

import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;

public class DrawPanel extends JPanel {

    private ArrayList<View.Rectangle> rectanglesClicked;
    private String aType;

    public DrawPanel(){
        rectanglesClicked = new ArrayList<>();
        setLayout(null);
    }


    public void boxClickTracker(Rectangle rectangle) {
        rectanglesClicked.add(rectangle);
        this.repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Line line;
        InheritanceArrow inheritanceArrow;
        CompositionArrow compositionArrow;
        AggregationArrow aggregationArrow;

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
                    compositionArrow = new CompositionArrow(coord, rectClasses);
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

}
