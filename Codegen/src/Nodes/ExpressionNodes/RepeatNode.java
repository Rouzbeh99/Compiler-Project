package Nodes.ExpressionNodes;

public class RepeatNode extends BlockContent {
    private Block body;
    private ExpressionNode condition;

    public RepeatNode(Block body, ExpressionNode condition) {
        this.body = body;
        this.condition = condition;
    }

    @Override
    public void compile() {
        // code to check the body and run body code
    }
}
