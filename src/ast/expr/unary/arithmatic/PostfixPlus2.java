package ast.expr.unary.arithmatic;

import ast.Node;
import ast.expr.unary.UnaryExpression;
import ast.type.Type;
import ast.type.TypeChecker;
import cg.Logger;
import org.objectweb.asm.Opcodes;
import symtab.dscp.VariableDescriptor;

import static cg.CodeGenerator.mVisit;

public class PostfixPlus2 extends DualOperation {

    public PostfixPlus2(VariableDescriptor descriptor) {
        super(descriptor);
    }

    @Override
    public Node compile() {
        Logger.log("postfix plus plus");
        Type resultType = TypeChecker.unaryExprTypeCheck(descriptor.getType());
        mVisit.visitVarInsn(ldrOp, descriptor.getStackIndex());
        mVisit.visitInsn(dupOp);
        mVisit.visitInsn(Opcodes.ICONST_1);
        mVisit.visitInsn(addOp);
        mVisit.visitVarInsn(strOp, descriptor.getStackIndex());
        return new UnaryExpression(resultType);
    }

}
