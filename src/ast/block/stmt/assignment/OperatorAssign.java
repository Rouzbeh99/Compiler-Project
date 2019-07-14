package ast.block.stmt.assignment;

import ast.access.Access;
import ast.access.ArrayAccess;
import ast.access.StructureAccess;
import ast.access.VariableAccess;
import ast.expr.Expression;
import ast.type.Type;
import cg.CodeGenerator;
import org.objectweb.asm.Opcodes;
import symtab.dscp.AbstractDescriptor;
import symtab.dscp.variable.GlobalVariableDescriptor;
import symtab.dscp.variable.VariableDescriptor;

import static cg.CodeGenerator.mVisit;

public abstract class OperatorAssign extends Assignment {

    int opcode;

    OperatorAssign(Access access, Expression expr) {
        super(access, expr);
    }

    @Override
    public void compile() {
        access.compile();
        descriptor = (AbstractDescriptor) access.getDescriptor();
        checkOperation();
        if (access instanceof VariableAccess)
            variableOperatorAssign();
        else if (access instanceof ArrayAccess)
            arrayOperatorAssign();
        else
            structOperatorAssign();
    }

    private void variableOperatorAssign() {
        access.push();
        expr.compile();
        expr.doCastCompile(descriptor.getType());
        CodeGenerator.mVisit.visitInsn(opcode);
        if (descriptor instanceof GlobalVariableDescriptor)
            mVisit.visitFieldInsn(Opcodes.PUTFIELD, CodeGenerator.GENERATED_CLASS, descriptor.getName(), descriptor.getType().typeName());
        else
            mVisit.visitVarInsn(determineOp(descriptor.getType()), descriptor.getStackIndex());
    }

    private void arrayOperatorAssign() {
        Type type = Type.toSimple(descriptor.getType());
        arrayStoreInit();
        access.compile();
        expr.compile();
        expr.doCastCompile(type);
        mVisit.visitInsn(opcode);
        mVisit.visitInsn(determineOp(type));
    }

    private void structOperatorAssign() {
        VariableDescriptor structVar = ((StructureAccess) access).getStructureVar();
        access.compile();
        expr.compile();
        expr.doCastCompile(structVar.getType());
        mVisit.visitInsn(opcode);
        mVisit.visitFieldInsn(Opcodes.PUTFIELD, descriptor.getType().typeName(), structVar.getName(), structVar.getType().typeName());
    }

}
