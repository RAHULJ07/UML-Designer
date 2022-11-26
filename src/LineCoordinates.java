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

    public String getArrowType() {
        return arrowType;
    }
}
