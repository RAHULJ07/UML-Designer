package Controller;

public class AssociationHandler implements IHandlerAction{

    protected IHandlerAction successor;

    public void setSuccessor(IHandlerAction successor){
        this.successor = successor;
    }
    @Override
    public void handleRequest(String action) {
        if(action.equals("Association")) {
            ArrowType.arrowType = "Association";
        } else if (successor!= null){
            successor.handleRequest(action);
        }
    }
}