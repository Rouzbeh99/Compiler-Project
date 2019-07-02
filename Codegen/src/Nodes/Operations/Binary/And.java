package Nodes.Operations.Binary;

import Nodes.ClassNode;
import Nodes.ExpressionNodes.ExpressionNode;

public class And extends BinaryExpression {


    public And(ExpressionNode expression1, ExpressionNode expression2) {
        super(expression1, expression2);
    }

    @Override
    public ClassNode compile() {
        super.compile();
        return null;
    }
}
