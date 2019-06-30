package Nodes.DCL;

import Nodes.ClassNode;

public class Variable extends ClassNode {
    private String name;
    private Type type;
    private boolean isConst;

    public Variable(String name, Type type, boolean isConst) {
        this.name = name;
        this.type = type;
        this.isConst = isConst;
    }

    @Override
    public void compile() {
        //make a descriptor, fill descriptor with name and type
    }
}
