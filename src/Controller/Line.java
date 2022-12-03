package Controller;

import Model.LineCoordinates;
import java.awt.*;

/**
 * Line class realizes IArrow.
 * @author Haritej Lakshmi Narayan, Chris Lazar, Sunayana Gupta, Rahul Kumar, Cameron Woehler, Bhavana Priya Kanumuri
 */
public class Line implements IArrow {

    private LineCoordinates coord;

    /**
     * Initializes the line co-ordinates
     * @param coord the x and y co-ordinates of the line
     */
    public Line(LineCoordinates coord) {
        this.coord = coord;
    }

    /**
     * Draws the line with its x and y co-ordinates
     * @param g2d graphical representation of relationship between classes
     */
    @Override
    public void draw(Graphics2D g2d) {
            g2d.setColor(Color.BLUE);
            g2d.drawLine(coord.getStartX(),coord.getStartY(),coord.getEndX(),coord.getEndY());
    }
}
