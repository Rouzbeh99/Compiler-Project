package Nodes.ExpressionNodes;


public class IntConstNode extends ExpressionNode {
    private int value;

    public IntConstNode(int value) {
        this.value = value;
    }

    @Override
    public void compile() {
        System.out.println("load");
        // code to load int const
    }
}
