package Nodes.Function;

import Nodes.ClassNode;
import Nodes.DCL.Type;

public class FunctionNode extends ClassNode {
    private SymbolTable symbolTable;
    private Type returnType;
    private String name;

    public FunctionNode(Type returnType, String name) {
        this.symbolTable = new SymbolTable();
        FunctionHandler.functionHandler.addToFunctions(this);
        SymbolTableHandler.symbolTableHandler.addToSymtab(symbolTable);
        this.returnType = returnType;
        this.name = name;
    }


    @Override
    public ClassNode compile() {
        return null;
    }
}
