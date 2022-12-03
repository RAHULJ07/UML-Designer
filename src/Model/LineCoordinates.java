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
     * public Constructor
     * @param startX
     * @param startY
     * @param endX
     * @param endY
     * @param arrowType
     */
    public LineCoordinates(int startX, int startY, int endX, int endY, String arrowType) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.arrowType = arrowType;
    }

    /**
     * get StartX
     * @return
     */
    public int getStartX() {
        return startX;
    }

    /**
     * get StartY
     * @return
     */
    public int getStartY() {
        return startY;
    }

    /**
     * get EndX
     * @return
     */
    public int getEndX() {
        return endX;
    }

    /**
     * get EndY
     * @return
     */
    public int getEndY() {
        return endY;
    }

    /**
     * set StartX
     * @param startX
     */
    public void setStartX(int startX) {
        this.startX = startX;
    }

    /**
     * set StartX
     * @param startY
     */
    public void setStartY(int startY) {
        this.startY = startY;
    }

    /**
     * set EndX
     * @param endX
     */
    public void setEndX(int endX) {
        this.endX = endX;
    }

    /**
     * set EndY
     * @param endY
     */
    public void setEndY(int endY) {
        this.endY = endY;
    }

    /**
     * get arrow type
     * @return
     */
    public String getArrowType() {
        return arrowType;
    }

    /**
     * set arrow type
     * @param arrowType
     */
    public void setArrowType(String arrowType) {
        this.arrowType = arrowType;
    }

    /**
     * converts variables to string
     * @return String containing instance variables
     */
    @Override
    public String toString(){
        String str;
        str = "LineCoordinates"+","+getArrowType() + "," + getStartX() + "," + getStartY()+ "," + getEndX() + "," + getEndY();
        return str;
    }
}
