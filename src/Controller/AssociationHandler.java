package Controller;

/**
 * AssociationHandler handles association selection.
 * @author Haritej Lakshmi Narayan, Chris Lazar, Sunayana Gupta, Rahul Kumar, Cameron Woehler, Bhavana Priya Kanumuri
 */
public class AssociationHandler implements IHandlerAction{

    protected IHandlerAction successor;

    /**
     * set successor
     * @param successor
     */
    public void setSuccessor(IHandlerAction successor){
        this.successor = successor;
    }

    /**
     * handler for Association selection
     * @param action current action
     */
    @Override
    public void handleRequest(String action) {
        if(action.equals("Association")) {
            ArrowType.arrowType = "Association";
        } else if (successor!= null){
            successor.handleRequest(action);
        }
    }
}