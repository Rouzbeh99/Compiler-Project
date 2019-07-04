package ast.expr.unary;

import ast.Node;
import ast.expr.Expression;
import ast.type.Type;

public class UnaryExpression extends Expression {

    protected Expression expr;

    public UnaryExpression(Type type) {
        super(type);
    }

    public UnaryExpression(Expression expr) {
        this.expr = expr;
    }

    @Override
    public Node compile() {
        return null;
    }

    @Override
    public int determineOp(Type type) {
        return 0;
    }

}
