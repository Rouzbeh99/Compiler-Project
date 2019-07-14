package ast.expr.constant;

import ast.type.Type;
import cg.CodeGenerator;
import cg.Logger;
import org.objectweb.asm.Opcodes;

public class CharConstant extends Constant {

    public CharConstant(Object value) {
        super(value);
        this.value = getChar(((StringBuilder) value).toString());
    }

    @Override
    public Type getResultType() {
        return Type.INT;
    }

    @Override
    public void compile() {
        Logger.log("character constant");
        CodeGenerator.mVisit.visitVarInsn(Opcodes.BIPUSH, (int) ((char) value));
    }

    private char getChar(String str) {
        String ch = str.substring(1, str.length() - 1);
        switch (ch) {
            case "\\b":
                return '\b';
            case "\\f":
                return '\f';
            case "\\n":
                return '\n';
            case "\\r":
                return '\r';
            case "\\t":
                return '\t';
            case "\\\\":
                return '\\';
            default:
                return ch.charAt(0);
        }
    }

}
