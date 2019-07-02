package Nodes.Function;

import Nodes.ClassNode;
import Nodes.DCL.Type;
import Nodes.DCL.VariableNode;
import Nodes.ExpressionNodes.Block;

import java.util.ArrayList;
import java.util.List;

public class FunctionNode extends ClassNode {
    private SymbolTable symbolTable;
    private Block block;
    private Type returnType;
    private String name;
    private List<VariableNode> arguments;

    public FunctionNode(Type returnType, String name) {
        this.symbolTable = new SymbolTable();
        arguments = new ArrayList<>();
        FunctionHandler.functionHandler.addToFunctions(this);
        SymbolTableHandler.symbolTableHandler.addToSymtab(symbolTable);
        this.returnType = returnType;
        this.name = name;
    }

    public void addToParams(VariableNode var){
        arguments.add(var);
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    public SymbolTable getSymbolTable() {
        return symbolTable;
    }

    public Type getReturnType() {
        return returnType;
    }

    public String getName() {
        return name;
    }

    @Override
    public ClassNode compile() {

        return null;
    }
}
