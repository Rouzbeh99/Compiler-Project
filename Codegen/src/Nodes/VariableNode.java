package Nodes;

public class VariableNode extends ClassNode {
    private String name;

    public VariableNode(String name) {
        this.name = name;
    }

    @Override
    public void compile() {
        // code to find value in describtor and push it to stack
    }
}
