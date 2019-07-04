package ast.expr.unary.arithmatic;

import ast.Node;
import ast.expr.unary.UnaryExpression;
import ast.type.Type;
import ast.type.TypeChecker;
import cg.Logger;
import org.objectweb.asm.Opcodes;
import symtab.dscp.VariableDescriptor;

import static cg.CodeGenerator.mVisit;

public class PrefixPlus2 extends DualOperation {

    public PrefixPlus2(VariableDescriptor descriptor) {
        super(descriptor);
    }

    @Override
    public Node compile() {
        Logger.log("prefix plus plus");
        Type resultType = TypeChecker.unaryExprTypeCheck(descriptor.getType());
        mVisit.visitInsn(Opcodes.ICONST_1);
        mVisit.visitVarInsn(ldrOp, descriptor.getStackIndex());
        mVisit.visitInsn(addOp);
        mVisit.visitInsn(dupOp);
        mVisit.visitVarInsn(strOp, descriptor.getStackIndex());
        return new UnaryExpression(resultType);
    }

}
