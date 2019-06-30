package Nodes.ExpressionNodes;

import java.util.Stack;

public class BlockHandler {
    private Stack<Block> blocks;
    public static final BlockHandler blockHandler = new BlockHandler();
    private BlockHandler(){
        blocks = new Stack<>();
    }

    public Stack<Block> getBlocks() {
        return blocks;
    }
}
