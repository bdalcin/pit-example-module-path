package operation.user;

import operation.Operation;

public class ServiceUser {

    public String render(Operation operation){
        return "Rendering " + operation.describeOperation();
    }
}
