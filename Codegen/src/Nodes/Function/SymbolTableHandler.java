package Nodes.Function;

import java.util.Stack;

public class SymbolTableHandler  {
    public static final SymbolTableHandler symbolTableHandler = new SymbolTableHandler();
    private Stack<SymbolTable> symbolTables ;
    private SymbolTable baseSymtab;

    public SymbolTableHandler() {
        symbolTables = new Stack<>();
        baseSymtab = new SymbolTable();
        symbolTables.push(baseSymtab);
    }

    public void addSymtab(SymbolTable symbolTable){
        symbolTables.push(symbolTable);
    }

    public SymbolTable getSymtab(){
        return symbolTables.peek();
    }

}
