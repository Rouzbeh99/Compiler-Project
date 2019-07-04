package ast.expr.binary.arithmatic;


import ast.Node;
import ast.expr.Expression;
import ast.type.Type;
import ast.type.VariableType;
import cg.Logger;
import org.objectweb.asm.Opcodes;

public class Add extends ArithmeticBinaryExpr {

    public Add(Expression expr1, Expression expr2) {
        super(expr1, expr2);
    }

    @Override
    public Node compile() {
        Logger.log("add");
        return super.compile();
    }

    @Override
    public int determineOp(Type type) {
        if (type == VariableType.DOUBL)
            return Opcodes.DADD;
        else if (type == VariableType.FLOAT)
            return Opcodes.FADD;
        else if (type == VariableType.LONG)
            return Opcodes.LADD;
        else
            return Opcodes.IADD;
    }

}
