package Nodes.CostNodes;
import Nodes.ClassNode;

public class IntConstNode extends ClassNode {
    private int value;

    public IntConstNode(int value) {
        this.value = value;
    }

    @Override
    public void compile() {
        // code to load int const
    }
}
