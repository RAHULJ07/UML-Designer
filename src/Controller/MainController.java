package Controller;

import View.AppPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller for Main and listens to Action.
 * @author Haritej Lakshmi Narayan, Chris Lazar, Sunayana Gupta, Rahul Kumar, Cameron Woehler, Bhavana Priya Kanumur
 */
public class MainController implements ActionListener {

    protected static MainController instance;

    private AppPanelController appPanelController;
    IHandlerAction compositionHandler;
    IHandlerAction associationHandler;
    IHandlerAction inheritanceHandler;
    IHandlerAction newOpHandler;
    IHandlerAction saveOpHandler;
    IHandlerAction loadOpHandler;

    /**
     * private constructor.
     */
    private MainController(){
        appPanelController = new AppPanelController(new AppPanel());
        newOpHandler = new NewOperationHandler();
        saveOpHandler = new SaveOperationHandler();
        loadOpHandler = new LoadOperationHandler();
        compositionHandler = new CompositionHandler();
        associationHandler = new AssociationHandler();
        inheritanceHandler = new InheritanceHandler();


        ((CompositionHandler) compositionHandler).setSuccessor(associationHandler);
        ((AssociationHandler) associationHandler).setSuccessor(inheritanceHandler);
        ((InheritanceHandler) inheritanceHandler).setSuccessor(newOpHandler);
        ((NewOperationHandler)newOpHandler).setSuccessor(saveOpHandler);
        ((SaveOperationHandler)saveOpHandler).setSuccessor(loadOpHandler);
    }

    /**
     * singleton instance of class.
     * @return
     */
    public static MainController getInstance(){
        if(instance == null)
            instance = new MainController();
        return instance;
    }

    /**
     * passing action to handler.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e){

        String action = e.getActionCommand();
        compositionHandler.handleRequest(action);
    }

    /**
     * get AppPanel controller
     * @return AppPanelController
     */
    public AppPanelController getAppPanelController() {
        return appPanelController;
    }
}
