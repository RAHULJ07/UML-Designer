package Controller;

public class CompositionHandler implements IHandlerAction{

    protected IHandlerAction successor;

    public void setSuccessor(IHandlerAction successor){
        this.successor = successor;
    }
    @Override
    public void handleRequest(String action) {
        if(action.equals("Composition")) {
            ArrowType.arrowType = "Composition";
        } else if (successor!= null){
            successor.handleRequest(action);
        }
    }
}
