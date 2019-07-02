package Nodes.ExpressionNodes;

import Nodes.ClassNode;

public class RepeatNode extends BlockContent {
    private Block body;
    private ExpressionNode condition;

    public RepeatNode(Block body, ExpressionNode condition) {
        this.body = body;
        this.condition = condition;
    }

    @Override
    public ClassNode compile() {
        // code to check the body and run body code

        return null;
    }
}
