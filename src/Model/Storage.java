package Model;

import java.util.ArrayList;
import java.util.List;

import View.*;

public class Storage implements Observable {

    protected static Storage instance;

    private ArrayList<RectangleModel> rectangles;
    private ArrayList<LineCoordinates> coordinates;
    private List<Observer> observerList;

    private Storage(){
        rectangles = new ArrayList<>();
        coordinates = new ArrayList<>();
        observerList = new ArrayList<>();
    }

    public static Storage getInstance(){
        if(instance == null)
            instance = new Storage();
        return instance;
    }

    @Override
    public void addObserver(Observer o){
        observerList.add(o);
    }

    @Override
    public void updateObserver(){
        for (Observer observer : observerList) {
            observer.update();

        }
    }

    public ArrayList<LineCoordinates> getCoordinates() {
        return coordinates;
    }

    public ArrayList<RectangleModel> getRectangles() {
        return rectangles;
    }

    public void addCoordinates(LineCoordinates coord) {

        coordinates.add(coord);
    }

    public void addRectangles(RectangleModel rectangle) {
        rectangles.add(rectangle);
    }

    public void addRectangle(RectangleModel rect) {
        rectangles.add(rect);
        StatusBar.getStatus().setStatus(String.format("Creating class: %s", rect.getClassName()));
        //updateObserver(rect.getClassName());
    }

    public void loadRectangle(RectangleModel rect) {
        rectangles.add(rect);
        updateObserver();
    }

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
