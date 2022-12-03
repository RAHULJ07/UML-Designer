package Controller;

import Model.Storage;
import View.DrawPanel;
import View.TextPanel;

public class NewOperationHandler implements IHandler {

    protected IHandler successor;

    public void setSuccessor(IHandler successor) {
        this.successor = successor;
    }

    @Override
    public void handleRequest(RequestType type) {
        if(type == RequestType.New){
            Storage storage = Storage.getInstance();
        	storage.getCoordinates().removeAll(storage.getCoordinates());
        	storage.getRectangles().removeAll(storage.getRectangles());
        	DrawPanel drawPanel = MainController.getInstance().getAppPanelController().getDrawPanelController().getDrawPanel();
        	TextPanel.getTextPanel().update();
        	drawPanel.removeAll();
        	drawPanel.updateUI();
        }else if(successor != null){
            successor.handleRequest(type);
        }

    }
}
