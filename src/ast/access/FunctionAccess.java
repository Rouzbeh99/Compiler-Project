package ast.access;

import ast.expr.Expression;
import ast.type.Type;
import cg.CodeGenerator;
import cg.Logger;
import org.objectweb.asm.Opcodes;
import symtab.dscp.function.FunctionDescriptor;
import symtab.dscp.function.Functions;

import java.util.List;

public class FunctionAccess extends Access {

    private List<Expression> parameters;

    public FunctionAccess(List<Expression> parameters) {
        this.parameters = parameters;
    }

    @Override
    public void setDescriptor(String id) {
        this.id = id;
    }

    @Override
    public void compile() {
        Logger.log("function access compile");
        Type[] parameterTypes = parameters.stream().map(Expression::getResultType).toArray(Type[]::new);
        if (!Functions.getInstance().contains(id, parameterTypes))
            Logger.error("no function definition found");
        descriptor = Functions.getInstance().get(id, parameterTypes);
    }

    @Override
    public void push() {
        Logger.log("function access invoke");
        FunctionDescriptor descriptor = (FunctionDescriptor) this.descriptor;
        parameters.forEach(Expression::compile);
        CodeGenerator.mVisit.visitMethodInsn(Opcodes.INVOKESTATIC, CodeGenerator.GENERATED_CLASS, descriptor.getName(), descriptor.getDescriptor(), false);
    }

    @Override
    public int determineOp(Type type) {
        return 0;
    }

}
