import java.awt.*;
import java.util.ArrayList;

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
