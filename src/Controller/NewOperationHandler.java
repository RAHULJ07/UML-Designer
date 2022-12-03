package Controller;

import Model.Storage;
import View.DrawPanel;
import View.TextPanel;

/**
 * Request handler when 'New' option is selected by user from menu.
 * @author Haritej Lakshmi Narayan, Chris Lazar, Sunayana Gupta, Rahul Kumar, Cameron Woehler, Bhavana Priya Kanumuri
 */
public class NewOperationHandler implements IHandler {

    protected IHandler successor;

    /**
     * Sets new instance when 'New' is selected from menu
     * @param successor new instance
     */
    public void setSuccessor(IHandler successor) {
        this.successor = successor;
    }

    /**
     * Removes all storage from current instance of the draw panel and updates the text panel
     * @param type of the request- 'New'
     */
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
