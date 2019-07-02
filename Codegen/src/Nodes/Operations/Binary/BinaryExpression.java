package Nodes.Operations.Binary;

import Nodes.ClassNode;
import Nodes.ExpressionNodes.ExpressionNode;

public class BinaryExpression extends ExpressionNode {

    private ExpressionNode expression1;
    private ExpressionNode expression2;

    public BinaryExpression(ExpressionNode expression1, ExpressionNode expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;

    }

    @Override
    public ClassNode compile() {
        expression1.compile();
        expression2.compile();
        return null;
    }
}
