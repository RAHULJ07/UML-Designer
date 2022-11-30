package Model;

public class LineCoordinates {

    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private String arrowType;

    public void setArrowType(String arrowType) {
        this.arrowType = arrowType;
    }

    public LineCoordinates(int startX, int startY, int endX, int endY, String arrowType) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.arrowType = arrowType;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }


    public void setStartX(int startX) {
        this.startX = startX;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public void setEndX(int endX) {
        this.endX = endX;
    }

    public void setEndY(int endY) {
        this.endY = endY;
    }

    public String getArrowType() {
        return arrowType;
    }

    @Override
    public String toString(){
        String str;
        str = getArrowType() + "," + getStartX() + "," + getStartY()+ "," + getEndX() + "," + getEndY();
        return str;
    }
}
