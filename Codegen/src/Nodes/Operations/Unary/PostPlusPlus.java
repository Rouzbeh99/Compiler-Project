package Nodes.Operations.Unary;

import Nodes.ClassNode;
import Nodes.ExpressionNodes.ExpressionNode;
import Nodes.Operations.Binary.BinaryExpression;

public class PostPlusPlus extends BinaryExpression {
    public PostPlusPlus(ExpressionNode expression1, ExpressionNode expression2) {
        super(expression1, expression2);
    }

    @Override
    public ClassNode compile() {
        super.compile();
        return null;
    }
}
