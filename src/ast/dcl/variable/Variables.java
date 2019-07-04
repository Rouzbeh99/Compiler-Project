package ast.dcl.variable;

import ast.type.Type;
import symtab.dscp.VariableDescriptor;

import java.util.ArrayList;
import java.util.List;

public class Variables {

    private static final Variables instance = new Variables();
    private List<LocalVariableDCL> dcls;
    private boolean constant;
    private Type type;

    private Variables() {
    }

    public static Variables getInstance() {
        return instance;
    }

    public void init() {
        dcls = new ArrayList<>();
        constant = false;
        type = null;
    }

    public boolean isConstant() {
        return constant;
    }

    public void setConstant(boolean constant) {
        this.constant = constant;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<LocalVariableDCL> getDcls() {
        return dcls;
    }

    public void addDscp(LocalVariableDCL dcl) {
        dcls.add(dcl);
    }

    public VariableDescriptor getLastDscp() {
        return dcls.get(dcls.size() - 1).getDescriptor();
    }

}
