package ast.expr.unary.logical;

import ast.Node;
import ast.expr.Expression;
import ast.expr.unary.UnaryExpression;
import ast.type.Type;
import ast.type.TypeChecker;
import ast.type.VariableType;
import cg.Logger;
import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;

import static cg.CodeGenerator.mVisit;

public class Not extends UnaryExpression {

    public Not(Expression expr) {
        super(expr);
    }

    @Override
    public Node compile() {
        Logger.log("not");
        Expression e = (Expression) expr.compile();
        Type resultType = TypeChecker.unaryExprTypeCheck(e.getType());
        int opcode = determineOp(resultType);
        Label l1 = new Label();
        Label l2 = new Label();
        mVisit.visitJumpInsn(opcode, l1);
        mVisit.visitInsn(Opcodes.ICONST_0);
        mVisit.visitJumpInsn(Opcodes.GOTO, l2);
        mVisit.visitLabel(l1);
        mVisit.visitInsn(Opcodes.ICONST_1);
        mVisit.visitLabel(l2);
        return new UnaryExpression(resultType);
    }

    @Override
    public int determineOp(Type type) {
        if (type == VariableType.INT)
            return Opcodes.IFEQ;
        Logger.error("type mismatch");
        return 0;
    }

}
