package Nodes.Function;

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
    public void compile() {
        //
    }
}
