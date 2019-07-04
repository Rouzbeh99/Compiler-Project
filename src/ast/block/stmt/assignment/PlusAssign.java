package ast.block.stmt.assignment;

import ast.Node;
import ast.expr.Expression;
import ast.type.Type;
import ast.type.VariableType;
import cg.Logger;
import org.objectweb.asm.Opcodes;
import symtab.dscp.VariableDescriptor;

public class PlusAssign extends OperatorAssign {

    public PlusAssign(VariableDescriptor descriptor, Expression expr) {
        super(descriptor, expr);
    }

    @Override
    public Node compile() {
        Logger.log("plus assignment");
        return super.compile();
    }

    @Override
    public void determineCodes(Type t1, Type t2) {
        super.determineCodes(t1, t2);
        if (t1 == VariableType.DOUBL)
            opcode = Opcodes.DADD;
        else if (t1 == VariableType.FLOAT)
            opcode = Opcodes.FADD;
        else if (t1 == VariableType.LONG)
            opcode = Opcodes.LADD;
        else if (t1 == VariableType.INT | t1 == VariableType.BOOL || t1 == VariableType.CHAR)
            opcode = Opcodes.IADD;
        else
            Logger.error("type mismatch");
    }

}
