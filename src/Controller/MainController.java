package Controller;

import View.AppPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController implements ActionListener {

    protected static MainController instance;

    private AppPanelController appPanelController;
    IHandlerAction h1;
    IHandlerAction h2;
    IHandlerAction h3;
    IHandlerAction newOpHandler;
    IHandlerAction saveOpHandler;
    IHandlerAction loadOpHandler;

    private MainController(){
        appPanelController = new AppPanelController(new AppPanel());
        newOpHandler = new NewOperationHandler();
        saveOpHandler = new SaveOperationHandler();
        loadOpHandler = new LoadOperationHandler();
        h1= new CompositionHandler();
        h2= new AssociationHandler();
        h3 = new InheritanceHandler();


        ((CompositionHandler) h1).setSuccessor(h2);
        ((AssociationHandler) h2).setSuccessor(h3);
        ((InheritanceHandler) h3).setSuccessor(newOpHandler);
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
        h1.handleRequest(action);
    }

    public AppPanelController getAppPanelController() {
        return appPanelController;
    }
}
