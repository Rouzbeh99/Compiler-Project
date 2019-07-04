package ast.block.stmt;

import ast.Node;
import ast.block.Blocks;
import cg.CodeGenerator;
import cg.Logger;
import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;

public class Continue extends Statement {

    @Override
    public Node compile() {
        Logger.log("continue");
        Label continuePoint = Blocks.getInstance().getCurrent().getStart();
        CodeGenerator.mVisit.visitJumpInsn(Opcodes.GOTO, continuePoint);
        return null;
    }

}
