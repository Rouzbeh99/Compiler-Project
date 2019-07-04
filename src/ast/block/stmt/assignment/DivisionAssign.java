package ast.block.stmt.assignment;

import ast.Node;
import ast.expr.Expression;
import ast.type.Type;
import ast.type.VariableType;
import cg.Logger;
import org.objectweb.asm.Opcodes;
import symtab.dscp.VariableDescriptor;

public class DivisionAssign extends OperatorAssign {

    public DivisionAssign(VariableDescriptor descriptor, Expression expr) {
        super(descriptor, expr);
    }

    @Override
    public Node compile() {
        Logger.log("division assignment");
        return super.compile();
    }

    @Override
    public void determineCodes(Type t1, Type t2) {
        super.determineCodes(t1, t2);
        if (t1 == VariableType.DOUBL)
            opcode = Opcodes.DDIV;
        else if (t1 == VariableType.FLOAT)
            opcode = Opcodes.FDIV;
        else if (t1 == VariableType.LONG)
            opcode = Opcodes.LDIV;
        else if (t1 == VariableType.INT | t1 == VariableType.BOOL || t1 == VariableType.CHAR)
            opcode = Opcodes.IDIV;
        else
            Logger.error("type mismatch");
    }
}
