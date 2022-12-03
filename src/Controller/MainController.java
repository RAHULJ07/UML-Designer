package Controller;

import View.AppPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController implements ActionListener {

    protected static MainController instance;

    private AppPanelController appPanelController;
    IHandlerAction compositionHandler;
    IHandlerAction associationHandler;
    IHandlerAction inheritanceHandler;
    IHandlerAction newOpHandler;
    IHandlerAction saveOpHandler;
    IHandlerAction loadOpHandler;

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

    public static MainController getInstance(){
        if(instance == null)
            instance = new MainController();
        return instance;
    }

    @Override
    public void actionPerformed(ActionEvent e){

        String action = e.getActionCommand();
        compositionHandler.handleRequest(action);
    }

    public AppPanelController getAppPanelController() {
        return appPanelController;
    }
}
