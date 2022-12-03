package Controller;

import Model.Storage;
import View.DrawPanel;
import View.TextPanel;

public class NewOperationHandler  extends CloseOperation implements IHandlerAction {

    protected IHandlerAction successor;

    public void setSuccessor(IHandlerAction successor) {
        this.successor = successor;
    }

    @Override
    public void handleRequest(String action) {
        if(action.equals("New")){
            super.close();
        }else if(successor != null){
            successor.handleRequest(action);
        }

    }
}
