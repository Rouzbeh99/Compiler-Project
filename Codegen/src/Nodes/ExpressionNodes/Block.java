package Nodes.ExpressionNodes;

import Nodes.ClassNode;

import java.util.ArrayList;
import java.util.List;

public class Block extends ClassNode {
    List<BlockContent> content;

    public Block() {
        content = new ArrayList<>();
        BlockHandler.blockHandler.getBlocks().push(this);
    }

    public void addToBlock(BlockContent blockContent){
        this.content.add(blockContent);

    }
}
