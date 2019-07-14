package ast.block.stmt.assignment;

import ast.access.Access;
import ast.expr.Expression;
import ast.type.Type;
import cg.Logger;
import org.objectweb.asm.Opcodes;

import static ast.type.Type.*;

public class PlusAssign extends OperatorAssign {

    public PlusAssign(Access access, Expression expr) {
        super(access, expr);
    }

    @Override
    public void compile() {
        Logger.log("plus assignment");
        super.compile();
    }

    @Override
    public int determineOp(Type type) {
        if (type == DOUBLE)
            opcode = Opcodes.DADD;
        else if (type == FLOAT)
            opcode = Opcodes.FADD;
        else if (type == LONG)
            opcode = Opcodes.LADD;
        else if (type == INT)
            opcode = Opcodes.IADD;
        else
            Logger.error("type mismatch");
        return super.determineOp(type);
    }

}
