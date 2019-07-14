package ast.expr.constant;

import ast.type.Type;
import cg.CodeGenerator;
import cg.Logger;
import org.objectweb.asm.Opcodes;

public class DoubleConstant extends Constant {

    public DoubleConstant(Object value) {
        super(value);
    }

    @Override
    public Type getResultType() {
        return Type.DOUBLE;
    }

    @Override
    public void compile() {
        Logger.log("double constant");
        Double main = (double) value;
        if (main.equals((double) 0))
            CodeGenerator.mVisit.visitInsn(Opcodes.DCONST_0);
        else if (main.equals((double) 1))
            CodeGenerator.mVisit.visitInsn(Opcodes.DCONST_1);
        else
            CodeGenerator.mVisit.visitLdcInsn(main);
    }

}
