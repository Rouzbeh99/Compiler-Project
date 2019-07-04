package ast.func;

import ast.Node;
import ast.expr.Expression;
import ast.type.Type;

import java.util.ArrayList;
import java.util.List;

public class FunctionCall extends Expression {

    private String name;
    private List<Expression> parameters;

    public FunctionCall(String name) {
        this.name = name;
        parameters = new ArrayList<>();
    }
    public void addToparameters(Expression exp){
        parameters.add(exp);
    }


    @Override
    public int determineOp(Type type) {
        return 0;
    }

    @Override
    public Node compile() {
        Function function = FunctionsHandler.instance.getFunctionByName(name);
        for (int i = 0; i < parameters.size(); i++) {
            if(!parameters.get(i).getType().equals(function.getArguments().get(i).getDescriptor().getType())){
                // Syntax Error
            }
            // code to invoke function
        }
        return null;
    }
}
