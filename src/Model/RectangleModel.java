package Model;

import View.DrawPanel;

/**
 * Model for the rectangle box created for new class
 * @author Haritej Lakshmi Narayan, Chris Lazar, Sunayana Gupta, Rahul Kumar, Cameron Woehler, Bhavana Priya Kanumuri
 */
public class RectangleModel {

    int xPos, yPos;
    String className;

    /**
     * initializes x co-ordinate, y co-ordinate and class name of the class
     * @param xPos x co-ordinate of the selected class
     * @param yPos y co-ordinate of the selected class
     * @param className class name of the selected class
     */
    public RectangleModel(int xPos, int yPos, String className){
        this.xPos = xPos;
        this.yPos = yPos;
        this.className = className;
    }

    /**
     * Getter method for getting class name
     * @return class name of the selected class
     */
    public String getClassName() {
        return className;
    }

    /**
     * Setter method for setting the class name
     * @param className class name of the selected class
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * Getter method for getting the x co-ordinates' position
     * @return x-coordinate
     */
    public int getxPos() {
        return xPos;
    }

    /**
     * Setter method for setting the x co-ordinate
     * @param xPos x-coordinate of the rectangle
     */
    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    /**
     *  getter method for getting the y coordinate
     * @return y coordinate of the rectangle
     */
    public int getyPos() {
        return yPos;
    }

    /**
     * setter method for setting the y coordinate
     * @param yPos y coordinate of the rectangle
     */
    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    /**
     * @return string with rectangle(class names) and its corresponding x and y coordinates
     */
    @Override
    public String toString(){
        String str;
        str = "Rectangles"+","+className + "," + xPos + "," + yPos;
        return str;
    }
}
