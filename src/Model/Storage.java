package Model;

import java.util.ArrayList;
import java.util.List;

import View.*;

/**
 * Storage model that saves classes, lines and observers. The Storage class realizes the observable.
 * Storage class is also a singleton class.
 * @author Haritej Lakshmi Narayan, Chris Lazar, Sunayana Gupta, Rahul Kumar, Cameron Woehler, Bhavana Priya Kanumuri
 */
public class Storage implements Observable {

    protected static Storage instance;

    private ArrayList<RectangleModel> rectangles;
    private ArrayList<LineCoordinates> coordinates;
    private List<Observer> observerList;

    /**
     * declares new arraylists for rectangles, coordinates and observers
     */
    private Storage(){
        rectangles = new ArrayList<>();
        coordinates = new ArrayList<>();
        observerList = new ArrayList<>();
    }

    /**
     * used to return an instance of the class if present or else create a new instance of the Storage class
     * @return new instance of storage class
     */
    public static Storage getInstance(){
        if(instance == null)
            instance = new Storage();
        return instance;
    }

    /**
     * add the observer to the observer list
     * @param o observer
     */
    @Override
    public void addObserver(Observer o){
        observerList.add(o);
    }

    /**
     * updates the observer in the observer list
     */
    @Override
    public void updateObserver(){
        for (Observer observer : observerList) {
            observer.update();

        }
    }

    /**
     * getter method to get the line coordinates
     * @return arraylist of x and y coordinates of the line
     */
    public ArrayList<LineCoordinates> getCoordinates() {
        return coordinates;
    }

    /**
     * getter method to get the rectangles
     * @return arraylist of rectangles(classes created)
     */
    public ArrayList<RectangleModel> getRectangles() {
        return rectangles;
    }

    /**
     * add the coordinates to a line
     * @param coord x and y coordinates
     */
    public void addCoordinates(LineCoordinates coord) {

        coordinates.add(coord);
    }

    public void addRectangles(RectangleModel rectangle) {
        rectangles.add(rectangle);
    }

    /**
     * add rectangle to the rectangle model
     * @param rect class name of the new class created
     */
    public void addRectangle(RectangleModel rect) {
        rectangles.add(rect);
        StatusBar.getStatus().setStatus(String.format("Creating class: %s", rect.getClassName()));
        //updateObserver(rect.getClassName());
    }

    /**
     * load the rectangle(classes) from a local user-submitted file
     * @param rect class name of class created
     */
    public void loadRectangle(RectangleModel rect) {
        rectangles.add(rect);
        updateObserver();
    }

    /**
     * getter method to get the rectangle's coordinates
     * @param x  x coordinate
     * @param y y coordinate
     * @return an empty string
     */
    public String getRectangleAt(int x, int y){
        for(RectangleModel rectangle: getRectangles()){
            if(x==rectangle.getxPos() && y==rectangle.getyPos()){
                return rectangle.getClassName();
            }
        }
        return "";
    }

    public void addLineCoordinate(LineCoordinates lineCoordinate) {
        coordinates.add(lineCoordinate);
        updateObserver();
        StatusBar.getStatus().setStatus(String.format("Creating relation: %s", lineCoordinate.getArrowType()));
    }
}
