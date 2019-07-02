package Nodes.ExpressionNodes;

import Nodes.ClassNode;

public class DivAssign extends AssignmentNode {
    public DivAssign(String name, ExpressionNode expressionNode) {
        super(name, expressionNode);
    }

    @Override
    public ClassNode compile() {
        return null;
    }
}
