package ast.dcl.array;

import ast.dcl.DCL;
import ast.dcl.variable.Variables;
import ast.expr.Expression;
import ast.type.Type;
import ast.type.TypeChecker;
import cg.CodeGenerator;
import cg.Logger;
import org.objectweb.asm.Opcodes;
import symtab.TableStack;
import symtab.dscp.array.ArrayDescriptor;

import static ast.type.Type.*;

public class ArrayDCL extends DCL {

    private Expression expr;

    public ArrayDCL(Expression expr) {
        this.expr = expr;
        descriptor = new ArrayDescriptor();
        descriptor.setConst(Variables.getInstance().isConstant());
        descriptor.setType(Type.toArray(Variables.getInstance().getType()));
    }

    @Override
    public void compile() {
        Logger.log("array declaration");
        if (!TypeChecker.isValidSwitchType(expr.getResultType()))
            Logger.error("invalid array size parameter");
        expr.compile();
        TableStack.getInstance().addVariable(descriptor);
        CodeGenerator.mVisit.visitVarInsn(Opcodes.NEWARRAY, determinePrimitiveType(descriptor.getType()));
    }

    private int determinePrimitiveType(Type type) {
        if (type == DOUBLE)
            return Opcodes.T_DOUBLE;
        else if (type == FLOAT)
            return Opcodes.T_FLOAT;
        else if (type == LONG)
            return Opcodes.T_LONG;
        else if (type == INT || type == CHAR || type == BOOL)
            return Opcodes.T_INT;
        else
            Logger.log("unsupported array type");
        return 0;
    }

}
