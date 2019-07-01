package Nodes.Operations.Unary;

import Nodes.ExpressionNodes.ExpressionNode;

public class UnaryExpression extends ExpressionNode {

    private ExpressionNode expression1l;

    public UnaryExpression(ExpressionNode expression1l) {
        this.expression1l = expression1l;
    }

    @Override
    public void compile() {
        expression1l.compile();
    }
}
