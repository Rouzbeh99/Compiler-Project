package Nodes.ExpressionNodes;

import Nodes.ClassNode;

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
    public ClassNode compile() {
        // if code here
        System.out.println("in if operation");
        System.out.println("if cond");
        condition.compile();
        System.out.println("if block");
        ifBlock.compile();
        System.out.println("else block");
        elseBlock.compile();
        System.out.println("if operation finished");
        return null;
    }
}
