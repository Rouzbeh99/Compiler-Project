package ast.expr.binary;

import ast.expr.Expression;
import ast.type.Type;
import ast.type.TypeChecker;

public abstract class BinaryExpression extends Expression {

    protected Expression expr1;
    protected Expression expr2;
    private Type resultType1;
    private Type resultType2;

    public BinaryExpression(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
        resultType1 = expr1.getResultType();
        resultType2 = expr2.getResultType();
    }

    public abstract int determineOp(Type type);

    @Override
    public Type getResultType() {
        return TypeChecker.binaryExprTypeCheck(resultType1, resultType2);
    }

    protected void compileExpressions(Type resultType) {
        expr1.compile();
        expr1.doCastCompile(resultType);
        expr2.compile();
        expr2.doCastCompile(resultType);
    }

}
