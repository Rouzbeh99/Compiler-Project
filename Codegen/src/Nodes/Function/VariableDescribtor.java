package Nodes.Function;

import Nodes.DCL.Type;

public class VariableDescribtor extends Descriptor {
    private Type type;
    private boolean isConst;
    private Type value; // what type ???????????????????????????
    private boolean isArgument;
    private SymbolTable super_symtab;

    public VariableDescribtor(String name, Type type, boolean isConst) {
        super(name);
        this.type = type;
        this.isConst = isConst;
    }

    public boolean isArgument() {
        return isArgument;
    }

    public void setArgument(boolean argument) {
        isArgument = argument;
    }

    public SymbolTable getSuper_symtab() {
        return super_symtab;
    }

    public void setSuper_symtab(SymbolTable super_symtab) {
        this.super_symtab = super_symtab;
    }

    public Type getType() {
        return type;
    }

    public boolean isConst() {
        return isConst;
    }

    public Type getValue() {
        return value;
    }

    public void setValue(Type value) {
        this.value = value;
    }
}
