package ast.expr.unary.arithmatic.dual;

import ast.access.Access;
import ast.type.Type;
import cg.Logger;
import org.objectweb.asm.Opcodes;

import static ast.type.Type.*;

public class PrefixPlus2 extends PreOperation {

    public PrefixPlus2(Access access) {
        super(access);
    }

    @Override
    public void compile() {
        Logger.log("prefix plus plus");
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
        else
            opcode = Opcodes.IADD;
        return super.determineOp(type);
    }

}
