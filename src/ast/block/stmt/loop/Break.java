package ast.block.stmt.loop;

import ast.block.Blocks;
import ast.block.stmt.Statement;
import cg.CodeGenerator;
import cg.Logger;
import org.objectweb.asm.Opcodes;

public class Break extends Statement {

    @Override
    public void compile() {
        Logger.log("break");
        CodeGenerator.mVisit.visitJumpInsn(Opcodes.GOTO, Blocks.getInstance().getCurrent().getEnd());
    }

}
