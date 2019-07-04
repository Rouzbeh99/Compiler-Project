package ast.block.stmt.assignment;

import ast.Node;
import ast.expr.Expression;
import cg.CodeGenerator;
import symtab.dscp.VariableDescriptor;

public class OperatorAssign extends Assignment {

    protected int opcode;

    public OperatorAssign(VariableDescriptor descriptor, Expression expr) {
        super(descriptor, expr);
    }

    @Override
    public Node compile() {
        super.compile();
        CodeGenerator.mVisit.visitVarInsn(ldrCode, descriptor.getStackIndex());
        CodeGenerator.mVisit.visitInsn(opcode);
        CodeGenerator.mVisit.visitVarInsn(strCode, descriptor.getStackIndex());
        return null;
    }

}
