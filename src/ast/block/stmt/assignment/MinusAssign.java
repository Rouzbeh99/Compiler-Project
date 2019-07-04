package ast.block.stmt.assignment;

import ast.Node;
import ast.expr.Expression;
import ast.type.Type;
import ast.type.VariableType;
import cg.Logger;
import org.objectweb.asm.Opcodes;
import symtab.dscp.VariableDescriptor;

public class MinusAssign extends OperatorAssign {

    public MinusAssign(VariableDescriptor descriptor, Expression expr) {
        super(descriptor, expr);
    }

    @Override
    public Node compile() {
        Logger.log("minus assignment");
        return super.compile();
    }

    @Override
    public void determineCodes(Type t1, Type t2) {
        super.determineCodes(t1, t2);
        if (t1 == VariableType.DOUBL)
            opcode = Opcodes.DSUB;
        else if (t1 == VariableType.FLOAT)
            opcode = Opcodes.FSUB;
        else if (t1 == VariableType.LONG)
            opcode = Opcodes.LSUB;
        else if (t1 == VariableType.INT | t1 == VariableType.BOOL || t1 == VariableType.CHAR)
            opcode = Opcodes.ISUB;
        else
            Logger.error("type mismatch");
    }

}
