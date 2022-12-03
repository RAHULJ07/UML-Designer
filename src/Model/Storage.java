package Model;

import java.util.ArrayList;
import java.util.List;
import View.*;

/**
 * Storage class is the representation of Blackboard
 * @author Haritej Lakshmi Narayan, Chris Lazar, Sunayana Gupta, Rahul Kumar, Cameron Woehler, Bhavana Priya Kanumuri
 */
public class Storage implements Observable {

    protected static Storage instance;

    private ArrayList<RectangleModel> rectangles;
    private ArrayList<LineCoordinates> coordinates;
    private List<Observer> observerList;

    /**
     * private Constructor
     */
    private Storage(){
        rectangles = new ArrayList<>();
        coordinates = new ArrayList<>();
        observerList = new ArrayList<>();
    }

    /**
     * Singleton instance
     * @return
     */
    public static Storage getInstance(){
        if(instance == null)
            instance = new Storage();
        return instance;
    }

    /**
     * Add Observer
     * @param o
     */
    @Override
    public void addObserver(Observer o){
        observerList.add(o);
    }

    /**
     * Update Observer
     */
    @Override
    public void updateObserver(){
        for (Observer observer : observerList) {
            observer.update();

        }
    }

    /**
     * get Coordinates list
     * @return
     */
    public ArrayList<LineCoordinates> getCoordinates() {
        return coordinates;
    }

    /**
     * get rectangle list
     * @return
     */
    public ArrayList<RectangleModel> getRectangles() {
        return rectangles;
    }

    /**
     * Add coordinate to coordinates list
     * @param coord
     */
    public void addCoordinates(LineCoordinates coord) {

        coordinates.add(coord);
    }

    /**
     * add rectangle to rectangle list
     * @param rect
     */
    public void addRectangle(RectangleModel rect) {
        rectangles.add(rect);
        StatusBar.getStatus().setStatus(String.format("Creating class: %s", rect.getClassName()));
    }

    /**
     * Load rectangle
     * @param rect
     */
    public void loadRectangle(RectangleModel rect) {
        rectangles.add(rect);
        updateObserver();
    }

    /**
     * get rectangle present at a particular location
     * @param x
     * @param y
     * @return
     */
    public String getRectangleAt(int x, int y){
        for(RectangleModel rectangle: getRectangles()){
            if(x==rectangle.getxPos() && y==rectangle.getyPos()){
                return rectangle.getClassName();
            }
        }
        return "";
    }

    /**
     * add LineCoordinate to coordinates list
     * @param lineCoordinate
     */
    public void addLineCoordinate(LineCoordinates lineCoordinate) {
        coordinates.add(lineCoordinate);
        updateObserver();
        StatusBar.getStatus().setStatus(String.format("Creating relation: %s", lineCoordinate.getArrowType()));
    }
}
