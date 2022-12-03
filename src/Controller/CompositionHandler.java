package Controller;

/**
 * CompositionHandler handles composition selection.
 * @author Haritej Lakshmi Narayan, Chris Lazar, Sunayana Gupta, Rahul Kumar, Cameron Woehler, Bhavana Priya Kanumuri
 */
public class CompositionHandler implements IHandlerAction{

    protected IHandlerAction successor;

    /**
     * set successor
     * @param successor
     */
    public void setSuccessor(IHandlerAction successor){
        this.successor = successor;
    }

    /**
     * handler for Composition selection
     * @param action
     */
    @Override
    public void handleRequest(String action) {
        if(action.equals("Composition")) {
            ArrowType.arrowType = "Composition";
        } else if (successor!= null){
            successor.handleRequest(action);
        }
    }
}
