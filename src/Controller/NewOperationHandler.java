package Controller;

/**
 * NewOperationHandler performs action on click of New operation.
 * @author Haritej Lakshmi Narayan, Chris Lazar, Sunayana Gupta, Rahul Kumar, Cameron Woehler, Bhavana Priya Kanumur
 */
public class NewOperationHandler  extends CloseOperation implements IHandlerAction {

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
    public void handleRequest(String action) {
        if(action.equals("New")){
            super.close();
        }else if(successor != null){
            successor.handleRequest(action);
        }
    }
}
