package ast.expr;

import ast.Node;
import ast.type.CastingType;
import ast.type.Type;
import cg.CodeGenerator;
import cg.Logger;
import org.objectweb.asm.Opcodes;

import static ast.type.CastingType.*;

public class CastExpr extends Expression {

    private Expression expr;
    private Type type;

    public CastExpr(Type type) {
        super(type);
    }

    public CastExpr(Type type, Expression expr) {
        this.expr = expr;
        this.type = type;
    }

    @Override
    public Node compile() {
        Logger.log("type casting");
        expr = (Expression) expr.compile();
        if (!(type instanceof CastingType))
            Logger.error("unsupported cast");

        if (type != expr.getType())
            CodeGenerator.mVisit.visitInsn(determineOp(type));
        return new CastExpr(type);
    }

    @Override
    public int determineOp(Type target) {
        Type source = expr.getType();
        if (target == DOUBL && source == FLOAT)
            return Opcodes.F2D;
        else if (target == FLOAT && source == DOUBL)
            return Opcodes.D2F;
        else if (target == DOUBL && source == INT)
            return Opcodes.I2D;
        else if (target == INT && source == DOUBL)
            return Opcodes.D2I;
        else if (target == FLOAT && source == INT)
            return Opcodes.I2F;
        else if (target == INT && source == FLOAT)
            return Opcodes.F2I;
        else if (target == INT && source == CHAR)
            return 0;
        else if (target == CHAR && source == INT)
            return Opcodes.I2C;
        else {
            Logger.error("unsupported cast");
            return 0;
        }
    }

}
