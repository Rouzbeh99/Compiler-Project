package Nodes.ExpressionNodes;

import Nodes.ClassNode;

public class MultAssign extends AssignmentNode {
    public MultAssign(String name, ExpressionNode expressionNode) {
        super(name, expressionNode);
    }

    @Override
    public ClassNode compile() {
        return null;
    }
}
