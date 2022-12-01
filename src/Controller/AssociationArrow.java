package Controller;

import Model.LineCoordinates;

import java.awt.*;

public class AssociationArrow extends Decorator {

    private LineCoordinates coord;
    private int x1, y1, x2, y2;

    public AssociationArrow(LineCoordinates coord) {
        this.coord = coord;
    }

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
        double t1 = 2*h/D;

        double xt = (1-t) * x2 + t * x1;
        double yt = (1-t) * y2 + t * y1;
        double m2 = (x1- x2)/(y2-y1);

        double sqrt = Math.sqrt(d * d / (m2 * m2 + 1));
        double y3 = m2 * sqrt + yt;
        double x3 = xt + sqrt;

        double y4 = yt - m2 * sqrt;
        double x4 = xt - sqrt;

        double x5 = (1-t1) * x2 + t1 * x1;
        double y5 = (1-t1) * y2 + t1 * y1;


        g2d.setColor(Color.BLUE);
        g2d.drawLine(x2,y2, (int) x3, (int) y3);
        g2d.drawLine(x2,y2, (int) x4, (int) y4);



    }
}
