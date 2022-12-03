package Controller;

/**
 * InheritanceHandler handles inheritance selection.
 * @author Haritej Lakshmi Narayan, Chris Lazar, Sunayana Gupta, Rahul Kumar, Cameron Woehler, Bhavana Priya Kanumuri
 */
public class InheritanceHandler implements IHandlerAction{

    protected IHandlerAction successor;

    /**
     * set successor
     * @param successor
     */
    public void setSuccessor(IHandlerAction successor){
        this.successor = successor;
    }

    /**
     * handler for Inheritance selection
     * @param action
     */
    @Override
    public void handleRequest(String action) {
        if(action.equals("Inheritance")) {
            ArrowType.arrowType = "Inheritance";
        }else if (successor!= null){
            successor.handleRequest(action);
        }
    }
}