package Nodes.ExpressionNodes;

public class IFNode extends BlockContent {
    private ExpressionNode condition;
    private Block ifBlock;
    private Block elseBlock;

    public IFNode(ExpressionNode condition, Block ifBlock, Block elseBlock) {
        this.condition = condition;
        this.ifBlock = ifBlock;
        this.elseBlock = elseBlock;
    }

    @Override
    public void compile() {
        // if code here
    }
}
