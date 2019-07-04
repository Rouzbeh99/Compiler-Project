package ast.func;

import ast.Node;
import ast.block.Block;
import ast.dcl.variable.LocalVariableDCL;
import ast.type.Type;
import symtab.SymbolTable;
import symtab.TableStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Function implements Node {
    private SymbolTable symbolTable;
    private Block block;
    private Type returnType;
    private String name;
    private List<LocalVariableDCL> arguments;

    public Function(Type returnType, String name) {
        this.symbolTable = new SymbolTable(new HashMap<>());
        arguments = new ArrayList<>();
        FunctionsHandler.instance.addToFunctions(this);
        TableStack.getInstance().pushSymbolTable(symbolTable);
        this.returnType = returnType;
        this.name = name;
    }

    public void addToParams(LocalVariableDCL var){
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

    public List<LocalVariableDCL> getArguments() {
        return arguments;
    }

    @Override
    public Node compile() {
        for (LocalVariableDCL argument : arguments) {
            symbolTable.put(argument.getDescriptor());
        }
        this.block.compile();//?????????????????????????????????????????
        return null;
    }
}

