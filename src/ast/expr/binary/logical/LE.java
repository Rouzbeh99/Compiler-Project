package ast.expr.binary.logical;

import ast.Node;
import ast.expr.Expression;
import ast.type.Type;
import cg.Logger;
import org.objectweb.asm.Opcodes;

public class LE extends LogicalBinaryExpr {

    public LE(Expression expr1, Expression expr2) {
        super(expr1, expr2);
    }

    @Override
    public Node compile() {
        Logger.log("less than equal");
        return super.compile();
    }

    @Override
    public int determineOp(Type type) {
        return Opcodes.IF_ICMPGT;
    }

}
