package ast.expr.unary.arithmatic;

import ast.expr.Expression;
import ast.expr.unary.UnaryExpression;
import ast.type.Type;
import cg.CodeGenerator;
import cg.Logger;
import org.objectweb.asm.Opcodes;

import static ast.type.Type.*;

public class Uminus extends UnaryExpression {

    public Uminus(Expression expr) {
        super(expr);
    }

    @Override
    public void compile() {
        Logger.log("unary minus");
        Type resultType = getResultType();
        expr.compile();
        CodeGenerator.mVisit.visitInsn(determineOp(resultType));
    }

    @Override
    public int determineOp(Type type) {
        if (type == DOUBLE)
            return Opcodes.DNEG;
        else if (type == FLOAT)
            return Opcodes.FNEG;
        else if (type == LONG)
            return Opcodes.LNEG;
        else
            return Opcodes.INEG;
    }

}
