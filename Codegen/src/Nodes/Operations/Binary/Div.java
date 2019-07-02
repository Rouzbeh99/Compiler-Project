package Nodes.Operations.Binary;

import Nodes.ClassNode;
import Nodes.ExpressionNodes.ExpressionNode;

public class Div extends BinaryExpression {


    public Div(ExpressionNode expression1, ExpressionNode expression2) {
        super(expression1, expression2);
    }

    @Override
    public ClassNode compile() {
        super.compile();
        System.out.println("Div operation");
        return null;
    }
}
