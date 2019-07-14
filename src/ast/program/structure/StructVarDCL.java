package ast.program.structure;

import ast.expr.constant.Constant;
import ast.program.ProgramContent;
import cg.CodeGenerator;
import cg.Logger;
import org.objectweb.asm.Opcodes;
import symtab.dscp.variable.VariableDescriptor;

public class StructVarDCL extends ProgramContent {

    private Constant constant;
    private VariableDescriptor descriptor;

    public StructVarDCL(Constant constant) {
        this.constant = constant;
        descriptor = new VariableDescriptor();
    }

    public VariableDescriptor getDescriptor() {
        return descriptor;
    }

    @Override
    public void compile() {
        Logger.log("declaring struct field");
        CodeGenerator.structClw.visitField
                (Opcodes.ACC_PUBLIC, descriptor.getName(), descriptor.getType().typeName(), null, null).visitEnd();
    }

    /**
     * structures should be initialized in class constructor so there will be two code generations for them.
     */
    public void init(String typeName) {
        Logger.log("initializing struct variable value in constructor");
        if (constant != null) {
            CodeGenerator.mVisit.visitVarInsn(Opcodes.ALOAD, 0);
            constant.compile();
            constant.doCastCompile(descriptor.getType());
            CodeGenerator.mVisit.visitFieldInsn(Opcodes.PUTFIELD, typeName, descriptor.getName(), descriptor.getType().typeName());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StructVarDCL that = (StructVarDCL) o;
        return descriptor.equals(that.descriptor);
    }

}
