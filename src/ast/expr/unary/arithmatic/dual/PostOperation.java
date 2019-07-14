package ast.expr.unary.arithmatic.dual;

import ast.access.Access;
import cg.CodeGenerator;
import org.objectweb.asm.Opcodes;
import symtab.dscp.variable.GlobalVariableDescriptor;

import static cg.CodeGenerator.mVisit;

public class PostOperation extends DualOperation {

    PostOperation(Access access) {
        super(access);
    }

    @Override
    public void compile() {
        super.compile();
        mVisit.visitInsn(dupOp);
        mVisit.visitInsn(constOp);
        mVisit.visitInsn(opcode);
        if (descriptor instanceof GlobalVariableDescriptor)
            mVisit.visitFieldInsn(Opcodes.PUTFIELD, CodeGenerator.GENERATED_CLASS, descriptor.getName(), descriptor.getType().typeName());
        else
            mVisit.visitVarInsn(strOp, descriptor.getStackIndex());
    }

}
