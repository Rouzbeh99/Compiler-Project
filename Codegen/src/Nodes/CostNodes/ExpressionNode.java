package Nodes.CostNodes;

import Nodes.ClassNode;

import java.util.List;

public class ExpressionNode extends ClassNode {
    List<ClassNode> subexp;

    public ExpressionNode(List<ClassNode> subexp) {
        this.subexp = subexp;
    }

    @Override
    public void compile() {
        for (ClassNode classNode : subexp) {
            // check conditions
            classNode.compile();
        }
    }
}
