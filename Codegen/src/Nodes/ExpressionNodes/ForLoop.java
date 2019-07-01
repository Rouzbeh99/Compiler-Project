package Nodes.ExpressionNodes;

public class ForLoop extends BlockContent {
    private ExpressionNode loopCond;
    private BlockContent loopBody;

    public ForLoop(ExpressionNode loopCond, BlockContent loopBody) {
        this.loopCond = loopCond;
        this.loopBody = loopBody;
    }

    @Override
    public void compile(){
        // code to check condition and run body code
    }
}
