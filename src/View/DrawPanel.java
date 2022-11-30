package View;

import Controller.*;
import Model.LineCoordinates;
import Model.Storage;
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

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
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

}
