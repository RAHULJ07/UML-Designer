package Model;

/**
 * LineCoordinates class is a Model class representing data in LineCoordinate
 * @author Haritej Lakshmi Narayan, Chris Lazar, Sunayana Gupta, Rahul Kumar, Cameron Woehler, Bhavana Priya Kanumuri
 */
public class LineCoordinates {

    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private String arrowType;

    /**
     * setter method for setting the arrowtype needed as a decorator to the line
     * @param arrowType
     */
    public void setArrowType(String arrowType) {
        this.arrowType = arrowType;
    }

    /**
     * sets the co-ordinates of the line along with the arrow type
     * @param startX initial x coordinate
     * @param startY initial y coordinate
     * @param endX end x coordinate
     * @param endY end y coordinate
     * @param arrowType type of arrowhead
     */
    public LineCoordinates(int startX, int startY, int endX, int endY, String arrowType) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.arrowType = arrowType;
    }

    /**
     * getter method to get the initial x coordinate
     * @return x-coordinate of the line
     */
    public int getStartX() {
        return startX;
    }

    /**
     * getter method to get the initial y coordinate
     * @return y-coordinate of the line
     */
    public int getStartY() {
        return startY;
    }

    /**
     * getter method to get the end x coordinate
     * @return x-coordinate of the line
     */
    public int getEndX() {
        return endX;
    }

    /**
     * getter method to get the end y coordinate
     * @return y-coordinate of the line
     */
    public int getEndY() {
        return endY;
    }

    /**
     * setter method to set the initial x coordinate
     * @param startX initial x coordinate
     */
    public void setStartX(int startX) {
        this.startX = startX;
    }

    /**
     * setter method to set the initial y coordinate
     * @param startY initial y coordinate
     */
    public void setStartY(int startY) {
        this.startY = startY;
    }

    /**
     * setter method to set the end x coordinate
     * @param endX end x coordinate
     */
    public void setEndX(int endX) {
        this.endX = endX;
    }

    /**
     * setter method to set the end y coordinate
     * @param endY end y coordinate
     */
    public void setEndY(int endY) {
        this.endY = endY;
    }

    /**
     * getter method to get the arrow type for the line
     * @return arrowtype
     */
    public String getArrowType() {
        return arrowType;
    }

    /**
     * @return string with line's arrow type, initial and final x and y coordinates
     */
    @Override
    public String toString(){
        String str;
        str = "LineCoordinates"+","+getArrowType() + "," + getStartX() + "," + getStartY()+ "," + getEndX() + "," + getEndY();
        return str;
    }
}
