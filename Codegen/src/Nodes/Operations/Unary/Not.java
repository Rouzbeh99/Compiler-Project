package Nodes.Operations.Unary;

import Nodes.ClassNode;
import Nodes.ExpressionNodes.ExpressionNode;

public class Not extends UnaryExpression {
    public Not(ExpressionNode expression1l) {
        super(expression1l);
    }

    @Override
    public ClassNode compile() {
        super.compile();
        return null;
    }
}
