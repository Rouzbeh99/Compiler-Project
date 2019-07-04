package ast.expr;

import ast.Node;
import ast.expr.unary.UnaryExpression;
import ast.type.Type;
import ast.type.TypeChecker;
import ast.type.VariableType;
import cg.CodeGenerator;
import cg.Logger;
import org.objectweb.asm.Opcodes;
import symtab.dscp.VariableDescriptor;

public class VariablePush extends Expression {

    private VariableDescriptor descriptor;

    public VariablePush(VariableDescriptor descriptor) {
        super(descriptor.getType());
        this.descriptor = descriptor;
    }

    @Override
    public Node compile() {
        Type type = descriptor.getType();
        if (!(TypeChecker.isValidExprType(type) || type == VariableType.STRING))
            Logger.error("type mismatch");

        CodeGenerator.mVisit.visitVarInsn(determineOp(type), descriptor.getStackIndex());
        return new UnaryExpression(type);
    }

    @Override
    public int determineOp(Type type) {
        if (type == VariableType.DOUBL)
            return Opcodes.DLOAD;
        else if (type == VariableType.FLOAT)
            return Opcodes.FLOAT;
        else if (type == VariableType.LONG)
            return Opcodes.LLOAD;
        else if (type == VariableType.STRING)
            return Opcodes.ALOAD;
        else
            return Opcodes.ILOAD;
    }

}
