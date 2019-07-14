package ast.access;

import ast.type.Type;
import cg.CodeGenerator;
import cg.Logger;
import org.objectweb.asm.Opcodes;
import symtab.dscp.function.FunctionDescriptor;
import symtab.dscp.function.Functions;

public class FunctionAccess extends Access {

    @Override
    public void setDescriptor(String id) {
        Type[] parameterTypes = FunctionAccessData.getInstance().getParameters();
        if (!Functions.getInstance().contains(id, parameterTypes))
            Logger.error("no function definition found");
        descriptor = Functions.getInstance().get(id, parameterTypes);
    }

    @Override
    public void compile() {
        Logger.log("function access invoke");
        FunctionDescriptor descriptor = (FunctionDescriptor) this.descriptor;
        CodeGenerator.mVisit.visitMethodInsn(Opcodes.INVOKESTATIC, CodeGenerator.GENERATED_CLASS, descriptor.getName(), descriptor.getDescriptor(), false);
    }

    @Override
    public void push() {
        //todo
    }

    @Override
    public int determineOp(Type type) {
        return 0;
    }

}
