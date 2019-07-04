package ast.expr.binary.arithmatic;

import ast.Node;
import ast.expr.Expression;
import ast.type.Type;
import ast.type.VariableType;
import cg.Logger;
import org.objectweb.asm.Opcodes;

public class BinaryAnd extends ArithmeticBinaryExpr {

    public BinaryAnd(Expression expr1, Expression expr2) {
        super(expr1, expr2);
    }

    @Override
    public Node compile() {
        Logger.log("binary and");
        return super.compile();
    }

    @Override
    public int determineOp(Type type) {
        if (type == VariableType.LONG && (expr1.getType() == VariableType.LONG && expr2.getType() == VariableType.LONG))
            return Opcodes.LAND;
        else if (type == VariableType.INT)
            return Opcodes.IAND;
        else
            Logger.error("type mismatch");
        return 0;
    }

}
