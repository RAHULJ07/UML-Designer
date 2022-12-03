package Controller;

import Model.Storage;
import View.DrawPanel;
import View.TextPanel;

public abstract class CloseOperation {

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
