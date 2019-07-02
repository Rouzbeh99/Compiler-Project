package Nodes.ExpressionNodes;

import Nodes.ClassNode;

public abstract class  AssignmentNode extends BlockContent {
    private String name;
    private ExpressionNode expressionNode;

    public AssignmentNode(String name, ExpressionNode expressionNode) {
        this.name = name;
        this.expressionNode = expressionNode;
    }

    @Override
    public ClassNode compile() {
        //code to check variable and assign it if it has super symtab it must also be updated
        System.out.println("assignment operation");
        System.out.println("calculating expr for assignment");
        expressionNode.compile();
        System.out.println("assignment done");
    return null;
    }
}
