package ast.expr.constant;

import ast.Node;
import ast.expr.Expression;
import ast.type.Type;
import cg.CodeGenerator;
import org.objectweb.asm.Opcodes;

public class Constant extends Expression {

    protected Object value;

    public Constant(Type type) {
        super(type);
    }

    public Constant(Object value) {
        this.value = value;
    }

    @Override
    public Node compile() {
        CodeGenerator.mVisit.visitLdcInsn(value);
        return null;
    }

    @Override
    public int determineOp(Type type) {
        return Opcodes.LDC;
    }

}
