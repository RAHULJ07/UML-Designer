package View;

/**
 * Base observable class from which various other classes inherit from. It can add and update observers.
 * @author Haritej Lakshmi Narayan, Chris Lazar, Sunayana Gupta, Rahul Kumar, Cameron Woehler, Bhavana Priya Kanumuri
 */
public interface Observable {
 
    public void addObserver(Observer o);
    public void updateObserver();
}
