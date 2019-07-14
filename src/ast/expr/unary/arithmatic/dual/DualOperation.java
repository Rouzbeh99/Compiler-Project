package ast.expr.unary.arithmatic.dual;

import ast.access.Access;
import ast.access.VariableAccess;
import ast.expr.unary.UnaryExpression;
import ast.type.Type;
import cg.Logger;
import org.objectweb.asm.Opcodes;
import symtab.dscp.AbstractDescriptor;
import symtab.dscp.variable.VariableDescriptor;

import static ast.type.Type.*;

public abstract class DualOperation extends UnaryExpression {

    AbstractDescriptor descriptor;
    Access access;
    int constOp;
    int strOp;
    int dupOp;
    int opcode;

    DualOperation(Access access) {
        super();
        this.access = access;
    }

    @Override
    public Type getResultType() {
        access.compile();
        return ((VariableDescriptor) access.getDescriptor()).getType();
    }

    private void checkOperation() {
        access.compile();
        descriptor = (VariableDescriptor) access.getDescriptor();
        if (descriptor.isConst())
            Logger.error("constant variables can't be changed");
        if (!(access instanceof VariableAccess))
            Logger.error("unsupported operation");
    }

    @Override
    public void compile() {
        checkOperation();
        determineOp(descriptor.getType());
        access.compile();
        access.push();
    }

    /**
     * In this class this method determines 4 operations so it doesn't return a specific value.
     *
     * @param type
     * @return
     */
    @Override
    public int determineOp(Type type) {
        if (type == DOUBLE) {
            constOp = Opcodes.DCONST_1;
            strOp = Opcodes.DSTORE;
            dupOp = Opcodes.DUP2;
        } else if (type == FLOAT) {
            constOp = Opcodes.FCONST_1;
            strOp = Opcodes.FSTORE;
            dupOp = Opcodes.DUP;
        } else if (type == LONG) {
            constOp = Opcodes.LCONST_1;
            strOp = Opcodes.LSTORE;
            dupOp = Opcodes.DUP2;
        } else if (type == INT) {
            constOp = Opcodes.ICONST_1;
            strOp = Opcodes.ISTORE;
            dupOp = Opcodes.DUP;
        } else
            Logger.error("invalid operation");
        return 0;
    }

}
