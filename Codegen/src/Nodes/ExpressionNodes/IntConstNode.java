package Nodes.ExpressionNodes;


import Nodes.ClassNode;

public class IntConstNode extends ExpressionNode {
    private int value;

    public IntConstNode(int value) {
        this.value = value;
    }

    @Override
    public ClassNode compile() {
        System.out.println("load int " + value);
        return null;
        // code to load int const
    }
}
