package Nodes.ExpressionNodes;

import Nodes.ClassNode;

import java.util.List;

public class CaseNode extends ClassNode {
    private List<CaseNode> cases;
    private int value;
    private Block block;

    public CaseNode(List<CaseNode> cases, int value, Block block) {
        this.cases = cases;
        this.value = value;
        this.block = block;
        cases.add(this);
    }

    @Override
    public void compile() {
        // switch class invokes this method
    }
}