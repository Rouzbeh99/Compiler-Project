package ast.expr.constant;

import ast.type.Type;
import cg.CodeGenerator;
import cg.Logger;
import org.objectweb.asm.Opcodes;

public class IntegerConstant extends Constant {

    public IntegerConstant(Object value) {
        super(value);
    }

    @Override
    public Type getResultType() {
        return Type.INT;
    }

    @Override
    public void compile() {
        Logger.log("integer constant");
        int main = (int) value;
        switch (main) {
            case -1:
                CodeGenerator.mVisit.visitInsn(Opcodes.ICONST_M1);
                break;
            case 0:
                CodeGenerator.mVisit.visitInsn(Opcodes.ICONST_0);
                break;
            case 1:
                CodeGenerator.mVisit.visitInsn(Opcodes.ICONST_1);
                break;
            case 2:
                CodeGenerator.mVisit.visitInsn(Opcodes.ICONST_2);
                break;
            case 3:
                CodeGenerator.mVisit.visitInsn(Opcodes.ICONST_3);
                break;
            case 4:
                CodeGenerator.mVisit.visitInsn(Opcodes.ICONST_4);
                break;
            case 5:
                CodeGenerator.mVisit.visitInsn(Opcodes.ICONST_5);
                break;
            default: {
                if (main > Byte.MIN_VALUE && main < Byte.MAX_VALUE)
                    CodeGenerator.mVisit.visitVarInsn(Opcodes.BIPUSH, main);
                else if (main > Short.MIN_VALUE && main < Short.MAX_VALUE)
                    CodeGenerator.mVisit.visitVarInsn(Opcodes.SIPUSH, main);
                else
                    CodeGenerator.mVisit.visitLdcInsn(value);
            }
        }
    }

}
