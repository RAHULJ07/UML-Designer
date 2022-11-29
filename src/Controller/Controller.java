package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    IHandler newOpHandler;
    IHandler saveOpHandler;
    IHandler loadOpHandler;

    public Controller(){
        newOpHandler = new NewOperationHandler();
        saveOpHandler = new SaveOperationHandler();
        loadOpHandler = new LoadOperationHandler();

        ((NewOperationHandler)newOpHandler).setSuccessor(saveOpHandler);
        ((SaveOperationHandler)saveOpHandler).setSuccessor(loadOpHandler);
    }

    @Override
    public void actionPerformed(ActionEvent e){

        String action = e.getActionCommand();

        if(action.equals("Composition")){
            ArrowType.arrowType = "Composition";
        }
        else if(action.equals("Aggregation")){
            ArrowType.arrowType = "Aggregation";
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
}
