package Nodes.ExpressionNodes;

import Nodes.ClassNode;

public class MinusAssign extends AssignmentNode {
    public MinusAssign(String name, ExpressionNode expressionNode) {
        super(name, expressionNode);
    }

    @Override
    public ClassNode compile() {
            return null;
    }
}
