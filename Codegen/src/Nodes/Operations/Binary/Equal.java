package Nodes.Operations.Binary;

import Nodes.ClassNode;
import Nodes.ExpressionNodes.ExpressionNode;

public class Equal extends BinaryExpression {

    public Equal(ExpressionNode expression1, ExpressionNode expression2) {
        super(expression1, expression2);
    }

    @Override
    public ClassNode compile() {
        super.compile();
        return null;
    }
}
