package Controller;

import Model.LineCoordinates;
import java.awt.*;

/**
 * InheritanceArrow is a decorator(arrowhead) for the Line class. It is an extension of the Decorator class.
 * @author Haritej Lakshmi Narayan, Chris Lazar, Sunayana Gupta, Rahul Kumar, Cameron Woehler, Bhavana Priya Kanumuri
 */
public class InheritanceArrow extends Decorator{
    private LineCoordinates coord;
    private int x1, y1, x2, y2;

    /**
     * Initializes the line co-ordinates for attaching the arrowhead
     * @param coord the x and y co-ordinates of the line
     */
    public InheritanceArrow(LineCoordinates coord) {
        this.coord = coord;
    }

    /**
     * draw(Graphics2D g2d) draws the arrowhead for inheritance relationship
     * @param g2d graphical representation of inheritance with a pointed triangle shape
     */
    @Override
    public void draw(Graphics2D g2d) {
        super.draw(g2d);
        x1 = coord.getStartX();
        y1 = coord.getStartY();
        x2 = coord.getEndX();
        y2 = coord.getEndY();
        double d = 10;
        double h = 15;
        int dx = x2 - x1, dy = y2 - y1;
        double D = Math.sqrt(dx*dx + dy*dy);
        double t = h/D;

        double xt = (1-t) * x2 + t * x1;
        double yt = (1-t) * y2 + t * y1;
        double m2 = (x1- x2)/(y2-y1);

        double sqrt = Math.sqrt(d * d / (m2 * m2 + 1));
        double y3 = m2 * sqrt + yt;
        double x3 = xt + sqrt;

        double y4 = yt - m2 * sqrt;
        double x4 = xt - sqrt;

        int[] xpoints = {x2, (int) x3, (int) x4};
        int[] ypoints = {y2, (int) y3, (int) y4};

        g2d.setColor(Color.getHSBColor(184, 172, 232));
        g2d.fillPolygon(xpoints, ypoints, 3);
        g2d.setColor(Color.BLUE);
        g2d.drawPolygon(xpoints, ypoints, 3);
    }

}
