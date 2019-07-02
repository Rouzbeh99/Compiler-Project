package Nodes.ExpressionNodes;

import Nodes.ClassNode;

public class VariableCall extends ExpressionNode {
    String name;

    public VariableCall(String name) {
        this.name = name;
    }

    @Override
    public ClassNode compile() {
        // search in symtab and ....
        System.out.println("load var " + name);
        return null;
    }
}
