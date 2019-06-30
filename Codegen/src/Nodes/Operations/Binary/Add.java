package Nodes.Operations.Binary;

import Nodes.ClassNode;
import Nodes.ConstNodes.ExpressionNode;

public class Add extends ExpressionNode {
    private ExpressionNode expression1;
    private ExpressionNode expression2;

    public Add(ExpressionNode expression1, ExpressionNode expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public void compile() {
        expression1.compile();
        expression2.compile();
        System.out.println("add operation");
        // now the values are the stack . just we need to write code to do add
    }
}