package ast.expr.unary;

import ast.expr.Expression;
import ast.type.Type;
import ast.type.TypeChecker;

public abstract class UnaryExpression extends Expression {

    protected Expression expr;

    protected UnaryExpression() {
    }

    public UnaryExpression(Expression expr) {
        this.expr = expr;
    }

    public abstract int determineOp(Type resultType);

    @Override
    public Type getResultType() {
        return TypeChecker.unaryExprTypeCheck(expr.getResultType());
    }

}
