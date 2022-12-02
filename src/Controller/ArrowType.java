package Controller;

/**
 * Controls the creation and initialization of new arrowhead types
 * @author Haritej Lakshmi Narayan, Chris Lazar, Sunayana Gupta, Rahul Kumar, Cameron Woehler, Bhavana Priya Kanumuri
 */
public class ArrowType {
    static String arrowType;

    /**
     * Setter method that sets new arrowhead types
     * @param arrowType
     */
    public static void setArrowType(String arrowType) {
        ArrowType.arrowType = arrowType;
    }

    /**
     * Getter method that gets the arrowhead type
     * @return the type of arrowhead a line has
     */
    public static String getArrowType() {
        return arrowType;
    }
}
