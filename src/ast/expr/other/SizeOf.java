package ast.expr.other;

import ast.expr.Expression;
import ast.type.Type;
import cg.CodeGenerator;
import cg.Logger;
import org.objectweb.asm.Opcodes;

public class SizeOf extends Expression {

    private Type type;

    public SizeOf(Type type) {
        this.type = type;
    }

    @Override
    public Type getResultType() {
        return Type.INT;
    }

    @Override
    public void compile() {
        Logger.log("sizeof operator");
        CodeGenerator.mVisit.visitVarInsn(Opcodes.BIPUSH, determineOp(type));
    }

    public int determineOp(Type type) {
        if (type == Type.CHAR)
            return 2;
        else if (type == Type.LONG || type == Type.DOUBLE)
            return 8;
        else
            return 4;
    }

}
