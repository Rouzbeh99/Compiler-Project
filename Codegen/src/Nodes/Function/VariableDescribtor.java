package Nodes.Function;

import Nodes.DCL.Type;

public class VariableDescribtor extends Descriptor {
    private Type type;
    private boolean isConst;
    private Type value; // what type ???????????????????????????

    public VariableDescribtor(String name, Type type, boolean isConst) {
        super(name);
        this.type = type;
        this.isConst = isConst;
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
