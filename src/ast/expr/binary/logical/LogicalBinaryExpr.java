package ast.expr.binary.logical;

import ast.Node;
import ast.expr.Expression;
import ast.expr.binary.BinaryExpression;
import ast.type.CastingType;
import ast.type.Type;
import ast.type.TypeChecker;
import ast.type.VariableType;
import cg.Logger;
import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;

import static cg.CodeGenerator.mVisit;

public class LogicalBinaryExpr extends BinaryExpression {

    private LogicalBinaryExpr(Type type) {
        super(type);
    }

    LogicalBinaryExpr(Expression expr1, Expression expr2) {
        super(expr1, expr2);
    }

    @Override
    public Node compile() {
        Expression e1 = (Expression) expr1.compile();
        Expression e2 = (Expression) expr2.compile();

        Type resultType = TypeChecker.binaryExprTypeCheck(e1.getType(), e2.getType());
        if (resultType != VariableType.INT)
            Logger.error("unsupported logical operation");

        Label l1 = new Label();
        Label l2 = new Label();
        mVisit.visitJumpInsn(determineOp(resultType), l1);
        mVisit.visitInsn(Opcodes.ICONST_1);
        mVisit.visitJumpInsn(Opcodes.GOTO, l2);
        mVisit.visitLabel(l1);
        mVisit.visitInsn(Opcodes.ICONST_0);
        mVisit.visitLabel(l2);
        return new LogicalBinaryExpr(resultType);
    }

    @Override
    public int determineOp(Type type) {
        return 0;
    }

}
