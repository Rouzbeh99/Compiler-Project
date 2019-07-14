package ast.block.stmt.loop;

import ast.block.Block;
import ast.block.stmt.Statement;
import ast.block.stmt.assignment.Assignment;
import ast.expr.Expression;
import ast.expr.constant.BooleanConstant;
import cg.Logger;
import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;

import static cg.CodeGenerator.mVisit;

public class For extends Statement {

    private Assignment init;
    private Expression condition;
    private Assignment update;
    private Block block;

    public For(Assignment init, Expression condition, Assignment update, Block block) {
        this.init = init;
        this.condition = condition;
        this.update = update;
        this.block = block;
    }

    @Override
    public void compile() {
        Logger.log("for loop");
        if (init != null)
            init.compile();
        block.init();
        Label loopStart = new Label();
        Label loopBody = new Label();
        mVisit.visitLabel(loopStart);
        if (condition != null)
            condition.compile();
        else
            new BooleanConstant(true).compile();
        mVisit.visitJumpInsn(Opcodes.IFEQ, block.getEnd());
        mVisit.visitJumpInsn(Opcodes.GOTO, loopBody);

        block.markStart();
        if (update != null)
            update.compile();
        mVisit.visitJumpInsn(Opcodes.GOTO, loopStart);

        mVisit.visitLabel(loopBody);
        block.compile();
        mVisit.visitJumpInsn(Opcodes.GOTO, block.getStart());
        block.markEnd();
    }

}
