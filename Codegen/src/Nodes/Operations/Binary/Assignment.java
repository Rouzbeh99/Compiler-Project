package Nodes.Operations.Binary;

import Nodes.ExpressionNodes.ExpressionNode;
import Nodes.DCL.VariableNode;
import Nodes.ExpressionNodes.StatementNode;

public class Assignment extends StatementNode {
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
