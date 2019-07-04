package ast.block.stmt.loop;

import ast.Assignment;
import ast.Node;
import ast.block.Block;
import ast.block.stmt.Statement;
import ast.expr.Expression;
import cg.CodeGenerator;
import cg.Logger;
import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;

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
    public Node compile() {
        Logger.log("for loop");

        init.compile();
        Label loopStart = new Label();
        Label loopBody = new Label();
        CodeGenerator.mVisit.visitLabel(loopStart);
        condition.compile();
        CodeGenerator.mVisit.visitJumpInsn(Opcodes.IFEQ, block.getEnd());
        CodeGenerator.mVisit.visitJumpInsn(Opcodes.GOTO, loopBody);

        block.markStart();
        update.compile();
        CodeGenerator.mVisit.visitJumpInsn(Opcodes.GOTO, loopStart);

        CodeGenerator.mVisit.visitLabel(loopBody);
        block.compile();
        block.markEnd();
        CodeGenerator.mVisit.visitJumpInsn(Opcodes.GOTO, block.getStart());
        return this;
    }

}
