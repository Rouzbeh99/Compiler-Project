package Nodes.Operations.Binary;

import Nodes.ExpressionNodes.ExpressionNode;

public class NotEq extends BinaryExpression {
    public NotEq(ExpressionNode expression1, ExpressionNode expression2) {
        super(expression1, expression2);
    }

    @Override
    public void compile() {
        super.compile();
    }
}