package ast.block.stmt.loop;

import ast.block.Block;
import ast.block.Blocks;
import ast.block.stmt.Statement;
import ast.expr.Expression;
import cg.CodeGenerator;
import cg.Logger;
import org.objectweb.asm.Opcodes;

public class Repeat extends Statement {

    private Block block;
    private Expression expr;

    public Repeat(Block block, Expression expr) {
        this.block = block;
        this.expr = expr;
    }

    @Override
    public void compile() {
        Logger.log("repeat");
        Blocks.getInstance().add(block);
        block.init();
        block.markStart();
        block.compile();
        expr.compile();
        CodeGenerator.mVisit.visitJumpInsn(Opcodes.IFEQ, block.getStart());
        block.markEnd();
        Blocks.getInstance().remove();
    }

}
