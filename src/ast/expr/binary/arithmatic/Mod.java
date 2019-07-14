package ast.expr.binary.arithmatic;

import ast.expr.Expression;
import ast.type.Type;
import cg.Logger;
import org.objectweb.asm.Opcodes;

import static ast.type.Type.*;

public class Mod extends ArithmeticBinaryExpr {

    public Mod(Expression expr1, Expression expr2) {
        super(expr1, expr2);
    }

    @Override
    public void compile() {
        Logger.log("remainder");
        super.compile();
    }

    @Override
    public int determineOp(Type type) {
        if (type == DOUBLE)
            return Opcodes.DREM;
        else if (type == FLOAT)
            return Opcodes.FREM;
        else if (type == LONG)
            return Opcodes.LREM;
        else
            return Opcodes.IREM;
    }

}
