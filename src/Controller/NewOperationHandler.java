package Controller;

/**
 * NewOperationHandler performs action on click of New operation.
 * @author Haritej Lakshmi Narayan, Chris Lazar, Sunayana Gupta, Rahul Kumar, Cameron Woehler, Bhavana Priya Kanumur
 */
public class NewOperationHandler  extends CloseOperation implements IHandlerAction {

    protected IHandlerAction successor;

    /**
     * set successor
     * @param successor
     */
    public void setSuccessor(IHandlerAction successor) {
        this.successor = successor;
    }

    /**
     * handle request on New operation
     * @param action
     */
    @Override
    public void handleRequest(String action) {
        if(action.equals("New")){
            super.close();
        }else if(successor != null){
            successor.handleRequest(action);
        }
    }
}
