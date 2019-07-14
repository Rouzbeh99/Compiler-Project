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
        try {
            CodeGenerator.mVisit.visitJumpInsn(Opcodes.GOTO, Blocks.getInstance().getCurrent().getEnd());
        } catch (Exception e) {
            Logger.error("break operation should only be used in loops");
        }
    }

}
