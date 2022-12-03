package Controller;

import java.awt.*;

/**
 *Decorator class realizes from IArrow class
 * @author Haritej Lakshmi Narayan, Chris Lazar, Sunayana Gupta, Rahul Kumar, Cameron Woehler, Bhavana Priya Kanumuri
 */
public class Decorator implements IArrow{

    protected IArrow iArrow;

    /**
     * Initializing iArrow
     * @param iArrow
     */
    public void add(IArrow iArrow){
        this.iArrow = iArrow;
    }

    /**
     * Draws the relationship between 2 classes
     * @param g2d graphical representation of relationship between classes
     */
    @Override
    public void draw(Graphics2D g2d) {
        iArrow.draw(g2d);
    }
}
