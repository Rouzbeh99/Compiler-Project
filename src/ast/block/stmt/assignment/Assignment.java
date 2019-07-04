package ast.block.stmt.assignment;

import ast.Node;
import ast.expr.Expression;
import ast.type.Type;
import cg.CodeGenerator;
import cg.Logger;
import org.objectweb.asm.Opcodes;
import symtab.dscp.VariableDescriptor;

import static ast.type.CastingType.*;
import static ast.type.StructureType.BOOL;
import static ast.type.StructureType.LONG;
import static ast.type.VariableType.STRING;

public class Assignment implements Node {

    protected VariableDescriptor descriptor;
    protected Expression expr;
    protected int castCode;
    protected int ldrCode;
    protected int strCode;

    public Assignment(VariableDescriptor descriptor, Expression expr) {
        this.descriptor = descriptor;
        this.expr = expr;
    }

    @Override
    public Node compile() {
        Type t1 = descriptor.getType();
        Type t2 = ((Expression) expr.compile()).getType();
        determineCodes(t1, t2);
        if (castCode != 0)
            CodeGenerator.mVisit.visitInsn(castCode);
        return null;
    }

    public void determineCodes(Type t1, Type t2) {
        if (t1 == STRING && t2 == STRING) {
            ldrCode = Opcodes.ALOAD;
            strCode = Opcodes.ASTORE;
        } else if (t1 == DOUBL) {
            ldrCode = Opcodes.DLOAD;
            strCode = Opcodes.DSTORE;
            if (t2 == FLOAT)
                castCode = Opcodes.F2D;
            else if (t2 == LONG)
                castCode = Opcodes.L2D;
            else if (t2 == INT)
                castCode = Opcodes.I2D;
        } else if (t1 == FLOAT) {
            ldrCode = Opcodes.FLOAT;
            strCode = Opcodes.FSTORE;
            if (t2 == DOUBL)
                castCode = Opcodes.D2F;
            else if (t2 == LONG)
                castCode = Opcodes.L2F;
            else if (t2 == INT)
                castCode = Opcodes.I2F;
        } else if (t1 == LONG) {
            ldrCode = Opcodes.LLOAD;
            strCode = Opcodes.LSTORE;
            if (t2 == DOUBL)
                castCode = Opcodes.D2L;
            else if (t2 == FLOAT)
                castCode = Opcodes.F2L;
            else if (t2 == INT)
                castCode = Opcodes.I2L;
        } else if (t1 == INT || t1 == BOOL || t1 == CHAR) {
            ldrCode = Opcodes.ILOAD;
            strCode = Opcodes.ISTORE;
            if (t2 == DOUBL)
                castCode = Opcodes.D2I;
            else if (t2 == FLOAT)
                castCode = Opcodes.F2I;
            else if (t2 == LONG)
                castCode = Opcodes.L2I;
        } else
            Logger.error("type mismatch");
    }

}
