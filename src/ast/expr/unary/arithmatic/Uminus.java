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

public class Uminus extends UnaryExpression {

    public Uminus(Expression expr) {
        super(expr);
    }

    @Override
    public Node compile() {
        Logger.log("unary minus");
        Expression e = (Expression) expr.compile();
        Type resultType = TypeChecker.unaryExprTypeCheck(e.getType());
        CodeGenerator.mVisit.visitInsn(determineOp(resultType));
        return new UnaryExpression(resultType);
    }

    @Override
    public int determineOp(Type type) {
        if (type == VariableType.DOUBL)
            return Opcodes.DNEG;
        else if (type == VariableType.FLOAT)
            return Opcodes.FNEG;
        else if (type == VariableType.LONG)
            return Opcodes.LNEG;
        else
            return Opcodes.INEG;
    }

}
