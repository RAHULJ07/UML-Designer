package Controller;

import Model.Storage;
import View.*;

/**
 * CloseOperation is an abstract class to promote code reusability for handlers.
 * @author Haritej Lakshmi Narayan, Chris Lazar, Sunayana Gupta, Rahul Kumar, Cameron Woehler, Bhavana Priya Kanumuri
 */
public abstract class CloseOperation {

    /**
     * close and clear objects
     */
    public void close(){
        Storage storage = Storage.getInstance();
        storage.getCoordinates().removeAll(storage.getCoordinates());
        storage.getRectangles().removeAll(storage.getRectangles());
        DrawPanel drawPanel = MainController.getInstance().getAppPanelController().getDrawPanelController().getDrawPanel();
        TextPanel.getTextPanel().update();
        drawPanel.removeAll();
        drawPanel.updateUI();
    }
}
