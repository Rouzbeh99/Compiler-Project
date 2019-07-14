package ast.expr.unary.arithmatic;

import ast.expr.Expression;
import ast.expr.unary.UnaryExpression;
import ast.type.Type;
import cg.CodeGenerator;
import cg.Logger;
import org.objectweb.asm.Opcodes;

import static ast.type.Type.*;

public class BinaryNot extends UnaryExpression {

    public BinaryNot(Expression expr) {
        super(expr);
    }

    @Override
    public void compile() {
        Logger.log("binary not");
        Type resultType = getResultType();
        expr.compile();
        CodeGenerator.mVisit.visitVarInsn(Opcodes.LDC, -1);
        CodeGenerator.mVisit.visitInsn(determineOp(resultType));
    }

    @Override
    public int determineOp(Type type) {
        if (type == INT)
            return Opcodes.IXOR;
        else if (type == LONG)
            return Opcodes.LXOR;
        else
            Logger.error("type mismatch");
        return 0;
    }

}
