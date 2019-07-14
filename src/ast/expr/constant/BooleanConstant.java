package ast.expr.constant;

import ast.type.Type;
import cg.CodeGenerator;
import cg.Logger;
import org.objectweb.asm.Opcodes;

public class BooleanConstant extends Constant {

    public BooleanConstant(Object value) {
        super(value);
    }

    @Override
    public Type getResultType() {
        return Type.INT;
    }

    @Override
    public void compile() {
        Logger.log("boolean constant");
        CodeGenerator.mVisit.visitInsn((Boolean) this.value ? Opcodes.ICONST_1 : Opcodes.ICONST_0);
    }

}
