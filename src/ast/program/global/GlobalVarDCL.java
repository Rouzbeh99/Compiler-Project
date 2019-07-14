package ast.program.global;

import ast.program.Program;
import ast.program.ProgramContent;
import ast.type.Type;
import ast.type.TypeChecker;
import cg.CodeGenerator;
import cg.Logger;
import org.objectweb.asm.Opcodes;
import symtab.TableStack;
import symtab.dscp.variable.GlobalVariableDescriptor;

public class GlobalVarDCL extends ProgramContent {

    private Type type;
    private String id;

    public GlobalVarDCL(Type type, String id) {
        this.type = type;
        this.id = id;
    }

    @Override
    public void compile() {
        Logger.log("global variable declaration");
        if (!TypeChecker.isValidVariableType(type))
            Logger.error("invalid type for global variable");
        GlobalVariableDescriptor descriptor = generate();
        TableStack.getInstance().addGlobal(descriptor);
        CodeGenerator.mainClw.visitField(Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC, id, type.typeName(), null, null).visitEnd();
    }

    private GlobalVariableDescriptor generate() {
        GlobalVariableDescriptor descriptor = new GlobalVariableDescriptor();
        descriptor.setName(id);
        descriptor.setType(type);
        return descriptor;
    }

}
