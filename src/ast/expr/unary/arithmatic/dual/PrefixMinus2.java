package ast.expr.unary.arithmatic.dual;

import ast.access.Access;
import ast.type.Type;
import cg.Logger;
import org.objectweb.asm.Opcodes;

import static ast.type.Type.*;

public class PrefixMinus2 extends PreOperation {

    public PrefixMinus2(Access access) {
        super(access);
    }

    @Override
    public void compile() {
        Logger.log("prefix minus minus");
        super.compile();
    }

    @Override
    public int determineOp(Type type) {
        if (type == DOUBLE)
            opcode = Opcodes.DSUB;
        else if (type == FLOAT)
            opcode = Opcodes.FSUB;
        else if (type == LONG)
            opcode = Opcodes.LSUB;
        else
            opcode = Opcodes.ISUB;
        return super.determineOp(type);
    }

}
