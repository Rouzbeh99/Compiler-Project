package ast.block.stmt.assignment;

import ast.Node;
import ast.expr.Expression;
import cg.CodeGenerator;
import cg.Logger;
import symtab.dscp.VariableDescriptor;

public class DirectAssign extends Assignment {

    public DirectAssign(VariableDescriptor descriptor, Expression expr) {
        super(descriptor, expr);
    }

    @Override
    public Node compile() {
        Logger.log("direct assignment");
        super.compile();
        CodeGenerator.mVisit.visitVarInsn(strCode, descriptor.getStackIndex());
        return null;
    }

}
