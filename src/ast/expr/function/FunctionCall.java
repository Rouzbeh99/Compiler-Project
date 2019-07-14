package ast.expr.function;

import ast.access.FunctionAccess;
import ast.expr.Expression;
import ast.type.Type;
import cg.Logger;
import symtab.dscp.function.FunctionDescriptor;

public class FunctionCall extends Expression {

    private FunctionAccess access;

    public FunctionCall(FunctionAccess access) {
        this.access = access;
    }

    @Override
    public Type getResultType() {
        return ((FunctionDescriptor) access.getDescriptor()).getReturnType();
    }

    @Override
    public void compile() {
        Logger.log("expression function call");
        access.compile();
    }

}
