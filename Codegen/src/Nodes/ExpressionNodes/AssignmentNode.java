package Nodes.ExpressionNodes;

public abstract class  AssignmentNode extends BlockContent {
    private String name;
    private ExpressionNode expressionNode;

    public AssignmentNode(String name, ExpressionNode expressionNode) {
        this.name = name;
        this.expressionNode = expressionNode;
    }

    @Override
    public void compile() {
        //code to check variable and assign it
    }
}
