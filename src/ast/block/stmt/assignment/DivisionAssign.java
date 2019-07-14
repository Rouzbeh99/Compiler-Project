package ast.block.stmt.assignment;

import ast.access.Access;
import ast.expr.Expression;
import ast.type.Type;
import cg.Logger;
import org.objectweb.asm.Opcodes;

import static ast.type.Type.*;

public class DivisionAssign extends OperatorAssign {

    public DivisionAssign(Access access, Expression expr) {
        super(access, expr);
    }

    @Override
    public void compile() {
        Logger.log("division assignment");
        super.compile();
    }

    @Override
    public int determineOp(Type type) {
        if (type == DOUBLE)
            opcode = Opcodes.DDIV;
        else if (type == FLOAT)
            opcode = Opcodes.FDIV;
        else if (type == LONG)
            opcode = Opcodes.LDIV;
        else if (type == INT)
            opcode = Opcodes.IDIV;
        else
            Logger.error("type mismatch");
        return super.determineOp(type);
    }

}
