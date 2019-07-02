package Nodes.ExpressionNodes;

import Nodes.ClassNode;

public class PlusAssign extends AssignmentNode {
    public PlusAssign(String name, ExpressionNode expressionNode) {
        super(name, expressionNode);
    }

    @Override
    public ClassNode compile() {
        return null;
    }
}
