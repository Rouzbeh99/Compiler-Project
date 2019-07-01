package Nodes.Operations.Binary;

import Nodes.ExpressionNodes.ExpressionNode;
import Nodes.DCL.VariableNode;
import Nodes.ExpressionNodes.StatementNode;

public class Assignment extends BinaryExpression {


    public Assignment(ExpressionNode expression1, ExpressionNode expression2) {
        super(expression1, expression2);
    }

    @Override
    public void compile() {
        super.compile();
    }
}
