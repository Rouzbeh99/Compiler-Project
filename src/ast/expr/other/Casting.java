package ast.expr.other;

import ast.expr.Expression;
import ast.type.Type;
import ast.type.TypeChecker;
import cg.Logger;

public class Casting extends Expression {

    private Expression expr;
    private Type type;

    public Casting(Type type, Expression expr) {
        this.expr = expr;
        this.type = type;
    }

    @Override
    public Type getResultType() {
        return TypeChecker.unaryExprTypeCheck(type);
    }

    @Override
    public void compile() {
        Logger.log("type casting");
        expr.compile();
        expr.doCastCompile(getResultType());
    }

}
