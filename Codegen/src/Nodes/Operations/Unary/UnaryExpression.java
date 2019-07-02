package Nodes.Operations.Unary;

import Nodes.ClassNode;
import Nodes.ExpressionNodes.ExpressionNode;

public class UnaryExpression extends ExpressionNode {

    private ExpressionNode expression1l;

    public UnaryExpression(ExpressionNode expression1l) {
        this.expression1l = expression1l;
    }

    @Override
    public ClassNode compile() {
        expression1l.compile();
        return null;
    }
}
