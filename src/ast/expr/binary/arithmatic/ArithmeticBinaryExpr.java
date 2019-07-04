package ast.expr.binary.arithmatic;

import ast.Node;
import ast.expr.Expression;
import ast.expr.binary.BinaryExpression;
import ast.type.Type;
import ast.type.TypeChecker;
import cg.CodeGenerator;

public class ArithmeticBinaryExpr extends BinaryExpression {

    private ArithmeticBinaryExpr(Type type) {
        super(type);
    }

    ArithmeticBinaryExpr(Expression expr1, Expression expr2) {
        super(expr1, expr2);
    }

    @Override
    public Node compile() {
        Expression e1 = (Expression) expr1.compile();
        Expression e2 = (Expression) expr2.compile();
        Type resultType = TypeChecker.binaryExprTypeCheck(e1.getType(), e2.getType());
        CodeGenerator.mVisit.visitInsn(determineOp(resultType));
        return new ArithmeticBinaryExpr(resultType);
    }

    @Override
    public int determineOp(Type type) {
        return 0;
    }

}
