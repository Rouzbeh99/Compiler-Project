package Nodes.Function;

import java.util.ArrayList;
import java.util.List;

public class FunctionHandler {
    public static final FunctionHandler functionHandler = new FunctionHandler();
    private List<FunctionNode> allFunctions;
    private FunctionHandler() {
        allFunctions = new ArrayList<>();
    }

    public FunctionNode getFunctionByName(String name){
        for (FunctionNode function : allFunctions) {
            if(function.getName().equals(name))
                return function;
        }
        return null;
    }

    public void addToFunctions(FunctionNode function){
        this.allFunctions.add(function);
    }
}
