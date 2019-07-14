package ast.expr.other;

import ast.access.Access;
import ast.expr.Expression;
import ast.type.Type;
import ast.type.TypeChecker;
import cg.Logger;
import symtab.dscp.AbstractDescriptor;

public class Variable extends Expression {

    private Access access;

    public Variable(Access access) {
        this.access = access;
    }

    @Override
    public Type getResultType() {
        Type type = ((AbstractDescriptor) access.getDescriptor()).getType();
        if (!TypeChecker.isValidVariableType(type))
            Logger.error("type mismatch");
        return type;
    }

    @Override
    public void compile() {
        Logger.log("variable push");
        access.compile();
    }

}
