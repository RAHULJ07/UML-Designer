package Controller;

public class NewOperationHandler implements IHandler {

    protected IHandler successor;

    public void setSuccessor(IHandler successor) {
        this.successor = successor;
    }

    @Override
    public void handleRequest(RequestType type) {
        if(type == RequestType.New){
        // flush and create new
        }else if(successor != null){
            successor.handleRequest(type);
        }

    }
}
