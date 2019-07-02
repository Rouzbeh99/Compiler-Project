package Nodes.ExpressionNodes;

import Nodes.ClassNode;

public class DirectAssignment extends AssignmentNode {
    public DirectAssignment(String name, ExpressionNode expressionNode) {
        super(name, expressionNode);
    }

    @Override
    public ClassNode compile() {
        super.compile();
        return null;
    }
}
