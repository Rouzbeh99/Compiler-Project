package ast.expr.binary;

import ast.expr.Expression;
import ast.type.Type;

public abstract class BinaryExpression extends Expression {

    protected Expression expr1;
    protected Expression expr2;

    public BinaryExpression(Type type) {
        super(type);
    }

    public BinaryExpression(Expression expr1, Expression expr2) {
        super();
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

}
