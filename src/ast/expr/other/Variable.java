package ast.expr.other;

import ast.access.Access;
import ast.access.ArrayAccess;
import ast.access.StructureAccess;
import ast.access.VariableAccess;
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
        access.compile();
        Type type;
        if (access instanceof VariableAccess)
            type = ((AbstractDescriptor) access.getDescriptor()).getType();
        else if (access instanceof ArrayAccess)
            type = Type.toSimple(((AbstractDescriptor) access.getDescriptor()).getType());
        else
            type = ((StructureAccess) access).getStructureVar().getType();
        if (!TypeChecker.isValidVariableType(type))
            Logger.error("type mismatch");
        return type;
    }

    @Override
    public void compile() {
        Logger.log("variable push");
        access.compile();
        access.push();
    }

}
