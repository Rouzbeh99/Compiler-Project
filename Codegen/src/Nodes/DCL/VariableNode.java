package Nodes.DCL;


import Nodes.ExpressionNodes.BlockContent;
import Nodes.Function.SymbolTableHandler;

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

        // get symboltable by SymbolTableHandler.symbolTableHandler.getSymtab();
        // make a descriptor , fill descriptor with name and type
        // add descriptor to symtab
    }
}
