package ast.expr.unary.arithmatic;

import ast.Node;
import ast.expr.Expression;
import ast.expr.unary.UnaryExpression;
import ast.type.Type;
import ast.type.TypeChecker;
import ast.type.VariableType;
import cg.CodeGenerator;
import cg.Logger;
import org.objectweb.asm.Opcodes;

public class BinaryNot extends UnaryExpression {

    public BinaryNot(Expression expr) {
        super(expr);
    }

    @Override
    public Node compile() {
        Logger.log("binary not");
        Expression e = (Expression) expr.compile();
        Type resultType = TypeChecker.unaryExprTypeCheck(e.getType());
        int opcode = determineOp(resultType);
        CodeGenerator.mVisit.visitVarInsn(Opcodes.LDC, -1);
        CodeGenerator.mVisit.visitInsn(opcode);
        return new UnaryExpression(resultType);
    }

    @Override
    public int determineOp(Type type) {
        if (type == VariableType.INT)
            return Opcodes.IXOR;
        else if (type == VariableType.LONG)
            return Opcodes.LXOR;
        else
            Logger.error("type mismatch");
        return 0;
    }

}
