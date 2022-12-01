package Controller;

import java.awt.*;

public class Decorator implements IArrow{

    protected IArrow iArrow;

    public void add(IArrow iArrow){
        this.iArrow = iArrow;
    }
    @Override
    public void draw(Graphics2D g2d) {
        iArrow.draw(g2d);
    }
}
