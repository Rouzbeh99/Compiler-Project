package ast.dcl.variable;

import ast.dcl.DCL;
import cg.Logger;
import org.objectweb.asm.Opcodes;
import symtab.TableStack;
import symtab.dscp.AbstractDescriptor;
import symtab.dscp.struct.Structures;

import static cg.CodeGenerator.mVisit;

public class StructDCL extends DCL {

    StructDCL(AbstractDescriptor descriptor) {
        this.descriptor = Structures.getInstance().newDescriptor(descriptor.getType());
        this.descriptor.setName(descriptor.getName());
        this.descriptor.setConst(descriptor.isConst());
    }

    @Override
    public void compile() {
        Logger.log("struct declaration");
        TableStack.getInstance().addVariable(descriptor);
        mVisit.visitTypeInsn(Opcodes.NEW, descriptor.getType().typeName());
        mVisit.visitInsn(Opcodes.DUP);
        mVisit.visitMethodInsn(Opcodes.INVOKESPECIAL, descriptor.getType().typeName(), "<init>", "()V", false);
        mVisit.visitVarInsn(Opcodes.ASTORE, descriptor.getStackIndex());
    }

}
