package Model;

/**
 * RectangleModel class is a Model class representing data in rectangle
 * @author Haritej Lakshmi Narayan, Chris Lazar, Sunayana Gupta, Rahul Kumar, Cameron Woehler, Bhavana Priya Kanumuri
 */
public class RectangleModel {

    int xPos, yPos;

    String className;

    /**
     * public constructor
     * @param xPos
     * @param yPos
     * @param className
     */
    public RectangleModel(int xPos, int yPos, String className){
        this.xPos = xPos;
        this.yPos = yPos;
        this.className = className;
    }

    /**
     * get class name
     * @return
     */
    public String getClassName() {
        return className;
    }

    /**
     * set class name
     * @param className
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * get xPos
     * @return
     */
    public int getxPos() {
        return xPos;
    }

    /**
     * set xPos
     * @param xPos
     */
    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    /**
     * get yPos
     * @return
     */
    public int getyPos() {
        return yPos;
    }

    /**
     * set yPos
     * @param yPos
     */
    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    /**
     * converts variables to string
     * @return String containing instance variables
     */
    @Override
    public String toString(){
        String str;
        str = "Rectangles"+","+className + "," + xPos + "," + yPos;
        return str;
    }
}
