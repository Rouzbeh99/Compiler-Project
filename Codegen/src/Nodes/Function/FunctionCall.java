package Nodes.Function;

import Nodes.ClassNode;
import Nodes.ExpressionNodes.ExpressionNode;

import java.util.ArrayList;
import java.util.List;

public class FunctionCall extends ExpressionNode {
    private String name;
    private List<ExpressionNode> parameters;

    public FunctionCall(String name) {
        this.name = name;
        parameters = new ArrayList<>();
    }
    public void addToparameters(ExpressionNode exp){
        parameters.add(exp);
    }

    @Override
    public ClassNode compile() {
        System.out.println("function called");
        FunctionNode function = FunctionHandler.functionHandler.getFunctionByName(name);
        if(function == null){
            System.out.println("function not declared");
        }else{
            System.out.println("pushing parameters on stack");
            function.compile();
        }
        System.out.println("function call finished");
        return null
   ; }
}
