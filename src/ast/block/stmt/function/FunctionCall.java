package ast.block.stmt.function;

import ast.access.FunctionAccess;
import ast.block.BlockContent;
import ast.type.Type;
import cg.CodeGenerator;
import cg.Logger;
import org.objectweb.asm.Opcodes;
import symtab.dscp.function.FunctionDescriptor;

import static ast.type.Type.*;

public class FunctionCall extends BlockContent {

    private FunctionAccess access;

    public FunctionCall(FunctionAccess access) {
        this.access = access;
    }

    @Override
    public void compile() {
        Logger.log("function call statement");
        access.compile();
        access.push();
        Type returnType = ((FunctionDescriptor) access.getDescriptor()).getReturnType();
        if (returnType != VOID)
            CodeGenerator.mVisit.visitInsn(!(returnType == DOUBLE || returnType == LONG) ? Opcodes.POP : Opcodes.POP2);
    }

}
