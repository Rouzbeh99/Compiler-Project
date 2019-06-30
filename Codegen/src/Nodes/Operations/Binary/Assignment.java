package Nodes.Operations.Binary;

import Nodes.ClassNode;
import Nodes.ConstNodes.ExpressionNode;
import Nodes.DCL.VariableNode;

public class Assignment extends ClassNode {
    private ExpressionNode expressionNode;
    private VariableNode variableNode;

    public Assignment(ExpressionNode expressionNode, VariableNode variableNode) {
        this.expressionNode = expressionNode;
        this.variableNode = variableNode;
    }

    @Override
    public void compile() {
        expressionNode.compile();
        System.out.println("do assignment");
        // code to update variableNode's descriptor
    }

}
