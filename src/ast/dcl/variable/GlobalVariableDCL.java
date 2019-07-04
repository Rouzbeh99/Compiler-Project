package ast.dcl.variable;

import ast.Node;
import ast.type.Type;
import cg.CodeGenerator;
import symtab.TableStack;
import symtab.dscp.VariableDescriptor;

public class GlobalVariableDCL implements Node {

    private Type type;
    private String name;

    public GlobalVariableDCL(Type type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override
    public Node compile() {
        //todo check if the type of structure is valid
//        VariableDescriptor descriptor = new VariableDescriptor(type, name, null);
//        descriptor.setArgument(false);
//        descriptor.setConst(false);
//        TableStack.getInstance().addGlobal(descriptor);
        return null;
    }

}
