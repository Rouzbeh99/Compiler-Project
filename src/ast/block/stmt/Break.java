package ast.block.stmt;

import ast.Node;
import ast.block.Blocks;
import cg.CodeGenerator;
import cg.Logger;
import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;

public class Break extends Statement {

    @Override
    public Node compile() {
        Logger.log("break");
        Label breakPoint = Blocks.getInstance().getCurrent().getEnd();
        CodeGenerator.mVisit.visitJumpInsn(Opcodes.GOTO, breakPoint);
        return null;
    }

}
