package ast.expr;

import ast.Node;
import ast.expr.constant.IntegerConstant;
import ast.type.CastingType;
import ast.type.Type;
import ast.type.VariableType;
import cg.CodeGenerator;
import org.objectweb.asm.Opcodes;

public class SizeOf extends Expression {

    private Type type;

    public SizeOf(Type type, Type type1) {
        super(type);
        this.type = type1;
    }

    @Override
    public Node compile() {
        CodeGenerator.mVisit.visitVarInsn(Opcodes.BIPUSH, determineOp(type));
        return new IntegerConstant(CastingType.INT);
    }

    /**
     * In this class this method doesn't return opcode itself but returns argument of the instruction.
     *
     * @param type
     * @return
     */
    @Override
    public int determineOp(Type type) {
        if (type == VariableType.CHAR)
            return 2;
        else if (type == VariableType.LONG || type == VariableType.DOUBL)
            return 8;
        else
            return 4;
    }

}
