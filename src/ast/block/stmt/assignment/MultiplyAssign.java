package ast.block.stmt.assignment;

import ast.Node;
import ast.expr.Expression;
import ast.type.Type;
import ast.type.VariableType;
import cg.Logger;
import org.objectweb.asm.Opcodes;
import symtab.dscp.VariableDescriptor;

public class MultiplyAssign extends Assignment {
    private int opcode;

    public MultiplyAssign(VariableDescriptor descriptor, Expression expr) {
        super(descriptor, expr);
    }

    @Override
    public Node compile() {
        Logger.log("multiply assignment");
        return super.compile();
    }

    @Override
    public void determineCodes(Type t1, Type t2) {
        super.determineCodes(t1, t2);
        if (t1 == VariableType.DOUBL)
            opcode = Opcodes.DMUL;
        else if (t1 == VariableType.FLOAT)
            opcode = Opcodes.FMUL;
        else if (t1 == VariableType.LONG)
            opcode = Opcodes.LMUL;
        else if (t1 == VariableType.INT | t1 == VariableType.BOOL || t1 == VariableType.CHAR)
            opcode = Opcodes.IMUL;
        else
            Logger.error("type mismatch");
    }

}
