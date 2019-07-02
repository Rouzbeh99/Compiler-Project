package Nodes.ExpressionNodes;

public class VariableCall extends ExpressionNode {
    String name;

    public VariableCall(String name) {
        this.name = name;
    }

    @Override
    public void compile() {
        // search in symtab and ....
    }
}
