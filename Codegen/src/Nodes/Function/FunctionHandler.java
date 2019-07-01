package Nodes.Function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionHandler {
    public static final FunctionHandler functionHandler = new FunctionHandler();
    private List<FunctionNode> functionNodes;
    private FunctionHandler() {
        functionNodes = new ArrayList<>();
    }

    public List<FunctionNode> getFunctionNodes() {
        return functionNodes;
    }

    public void addToFunctions(FunctionNode function){
        this.functionNodes.add(function);
    }
}
