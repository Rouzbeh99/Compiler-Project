package ast.expr;

import ast.Node;
import ast.type.Type;

public abstract class Expression implements Node {

    private Type type;

    public Expression() {
    }

    public Expression(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public abstract int determineOp(Type type);

}
