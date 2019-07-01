package Nodes.ExpressionNodes;

import Nodes.DCL.VariableNode;

import java.util.ArrayList;
import java.util.List;

public class SwitchNode extends BlockContent {
    private VariableNode variable;
    private List<CaseNode> cases;

    public SwitchNode(VariableNode variable) {
        this.variable = variable;
        cases = new ArrayList<>();
    }

    @Override
    public void compile() {
        // code to invoke cases
    }
}
