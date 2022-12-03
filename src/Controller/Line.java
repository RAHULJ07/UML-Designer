package Controller;

import Model.LineCoordinates;

import java.awt.*;

public class Line implements IArrow {

    private LineCoordinates coord;

    public Line(LineCoordinates coord) {
        this.coord = coord;
    }

    @Override
    public void draw(Graphics2D g2d) {
            g2d.setColor(Color.BLUE);
            g2d.drawLine(coord.getStartX(),coord.getStartY(),coord.getEndX(),coord.getEndY());
    }
}
