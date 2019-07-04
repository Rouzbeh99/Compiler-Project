package ast.func;

import java.util.ArrayList;
import java.util.List;


public class FunctionsHandler {
    public static final FunctionsHandler instance = new FunctionsHandler();
    private List<Function> allFunctions;
    private FunctionsHandler() {
        allFunctions = new ArrayList<>();
    }

    public Function getFunctionByName(String name){
        for (Function function : allFunctions) {
            if(function.getName().equals(name))
                return function;
        }
        return null;
    }

    public void addToFunctions(Function function){
        this.allFunctions.add(function);
    }
}

