package Nodes.DCL;


import Nodes.ExpressionNodes.BlockContent;

public class VariableNode extends BlockContent {
    private String name;
    private Type type;
    private boolean isConst;

    public VariableNode(String name, Type type, boolean isConst) {
        this.name = name;
        this.type = type;
        this.isConst = isConst;
    }

    @Override
    public void compile() {
        System.out.println("push variable");
        //make a descriptor, fill descriptor with name and type
    }
}
