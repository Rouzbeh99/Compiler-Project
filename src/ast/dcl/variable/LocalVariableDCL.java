package ast.dcl.variable;

import ast.Node;
import ast.type.Type;
import ast.type.TypeChecker;
import ast.type.VariableType;
import cg.CodeGenerator;
import cg.Logger;
import org.objectweb.asm.Opcodes;
import symtab.TableStack;
import symtab.dscp.VariableDescriptor;

public class LocalVariableDCL implements Node {

    private VariableDescriptor descriptor;

    public LocalVariableDCL(VariableDescriptor descriptor) {
        this.descriptor = descriptor;
    }

    @Override
    public Node compile() {
        TableStack.getInstance().addVariable(descriptor);
//        if (descriptor.getValue() != null)
            CodeGenerator.mVisit.visitVarInsn(determineOp(descriptor), descriptor.getStackIndex());
        return null;
    }

    public int determineOp(VariableDescriptor descriptor) {
        Type type = descriptor.getType();
        if (!TypeChecker.isValidVariableType(type))
            Logger.error("invalid assignment");

        if (type == VariableType.DOUBL)
            return Opcodes.DSTORE;
        else if (type == VariableType.FLOAT)
            return Opcodes.FSTORE;
        else if (type == VariableType.LONG)
            return Opcodes.LSTORE;
        else if (type == VariableType.AUTO) {
//            Type newType = TypeChecker.getAutoType(descriptor.getValue());
//            descriptor.setType(newType);
            return determineOp(descriptor);
        } else if (type == VariableType.INT || type == VariableType.CHAR || type == VariableType.BOOL)
            return Opcodes.ISTORE;
        else
            return Opcodes.ASTORE;
    }

    public VariableDescriptor getDescriptor() {
        return descriptor;
    }

}
