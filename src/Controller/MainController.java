package Controller;

import View.AppPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * MainController initializes application panel.
 * Depending on the given user input, it initializes menu option request handlers or sets the arrow type.
 * MainController realizes ActionListener.
 * MainController is a singleton class.
 * @author Haritej Lakshmi Narayan, Chris Lazar, Sunayana Gupta, Rahul Kumar, Cameron Woehler, Bhavana Priya Kanumuri
 */
public class MainController implements ActionListener {

    protected static MainController instance;

    private AppPanelController appPanelController;
    IHandler newOpHandler;
    IHandler saveOpHandler;
    IHandler loadOpHandler;

    private MainController(){
        appPanelController = new AppPanelController(new AppPanel());
        newOpHandler = new NewOperationHandler();
        saveOpHandler = new SaveOperationHandler();
        loadOpHandler = new LoadOperationHandler();

        ((NewOperationHandler)newOpHandler).setSuccessor(saveOpHandler);
        ((SaveOperationHandler)saveOpHandler).setSuccessor(loadOpHandler);
    }

    /**
     * An instance of the main controller is returned.
     * @return instance of the MainController
     */
    public static MainController getInstance(){
        if(instance == null)
            instance = new MainController();
        return instance;
    }

    /**
     * Sets the arrow type or initializes a request handler when an action button from the menu is selected.
     * @param e action event for selecting items from menu
     */
    @Override
    public void actionPerformed(ActionEvent e){

        String action = e.getActionCommand();

        if(action.equals("Composition")){
            ArrowType.arrowType = "Composition";
        }
        else if(action.equals("Association")){
            ArrowType.arrowType = "Association";
        }
        else if(action.equals("Inheritance")){
            ArrowType.arrowType = "Inheritance";
        }
        else if(action.equals("New")){
            newOpHandler.handleRequest(RequestType.New);
        }
        else if(action.equals("Save")){
            saveOpHandler.handleRequest(RequestType.Save);
        }else if(action.equals("Load")){
            loadOpHandler.handleRequest(RequestType.Load);
        }

    }

    /**
     * Getter method to get the application panel controller
     * @return Application panel controller
     */
    public AppPanelController getAppPanelController() {
        return appPanelController;
    }
}
