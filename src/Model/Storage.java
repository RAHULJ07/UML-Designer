package Model;

import java.util.ArrayList;
import java.util.List;

import View.*;

public class Storage implements Observable {

    protected static Storage instance;

    private ArrayList<Rectangle> rectangles;

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
    public void updateObserver(String className){
        for (Observer observer : observerList) {
            observer.update(className);

        }
    }

    public ArrayList<LineCoordinates> getCoordinates() {
        return coordinates;
    }

    public ArrayList<Rectangle> getRectangles() {
        return rectangles;
    }

    public void addCoordinates(LineCoordinates coord) {

        coordinates.add(coord);
    }

    public void addRectangles(Rectangle rectangle) {
        rectangles.add(rectangle);
    }

    public void addRectangle(Rectangle rect) {
        rectangles.add(rect);
        updateObserver(rect.getClassName());
    }

    public void addLineCoordinate(LineCoordinates lineCoordinate) {
        coordinates.add(lineCoordinate);
        //updateObserver("Dummy");
    }
}
