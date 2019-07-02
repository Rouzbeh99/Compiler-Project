package Nodes.ExpressionNodes;

import Nodes.ClassNode;
import Nodes.DCL.VariableNode;

public class ForeachNode extends BlockContent {
    VariableNode loopInvariant;
    VariableNode array;
    Block body;

    @Override
    public ClassNode compile() {
        //
        return null;
    }
}
