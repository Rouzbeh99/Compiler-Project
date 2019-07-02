package Nodes.DCL;


import Nodes.ClassNode;
import Nodes.ExpressionNodes.ExpressionNode;

public class VariableNode extends ExpressionNode {
    private String name;
    private Type type;
    private boolean isConst;

    public VariableNode(String name, Type type, boolean isConst) {
        this.name = name;
        this.type = type;
        this.isConst = isConst;
    }


    @Override
    public ClassNode compile() {

        // get symboltable by SymbolTableHandler.symbolTableHandler.getSymtab();
        // make a descriptor , fill descriptor with name and type
        // add descriptor to symtab
        System.out.println("declare var");
        return null;
    }
}
