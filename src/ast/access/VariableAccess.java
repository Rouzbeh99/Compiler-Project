package ast.access;

import ast.type.Type;
import cg.CodeGenerator;
import cg.Logger;
import org.objectweb.asm.Opcodes;
import symtab.TableStack;
import symtab.dscp.variable.GlobalVariableDescriptor;
import symtab.dscp.variable.VariableDescriptor;

import static ast.type.Type.*;

public class VariableAccess extends Access {

    @Override
    public void compile() {
        Logger.log("variable access");
        descriptor = TableStack.getInstance().find(id);
        if (!(descriptor instanceof VariableDescriptor)) {
            System.err.println(descriptor == null);
            Logger.error("variable not declared");
        }
    }

    @Override
    public void push() {
        Logger.log("loading variable access");
        VariableDescriptor descriptor = (VariableDescriptor) this.descriptor;
        if (descriptor instanceof GlobalVariableDescriptor)
            CodeGenerator.mVisit.visitFieldInsn(Opcodes.GETSTATIC, CodeGenerator.GENERATED_CLASS, descriptor.getName(), descriptor.getType().typeName());
        else
            CodeGenerator.mVisit.visitVarInsn(determineOp(descriptor.getType()), descriptor.getStackIndex());
    }

    @Override
    public int determineOp(Type type) {
        if (type == DOUBLE)
            return Opcodes.DLOAD;
        else if (type == FLOAT)
            return Opcodes.FLOAT;
        else if (type == LONG)
            return Opcodes.LLOAD;
        else if (type == INT)
            return Opcodes.ILOAD;
        else
            return Opcodes.ALOAD;
    }

}
