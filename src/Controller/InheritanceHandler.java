package Controller;

public class InheritanceHandler implements IHandlerAction{

    protected IHandlerAction successor;

    public void setSuccessor(IHandlerAction successor){
        this.successor = successor;
    }
    @Override
    public void handleRequest(String action) {
        if(action.equals("Inheritance")) {
            ArrowType.arrowType = "Inheritance";
        }else if (successor!= null){
            successor.handleRequest(action);
        }
    }
}