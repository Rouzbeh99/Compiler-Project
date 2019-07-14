package ast.block.stmt.conditional.ifstmt;

import ast.block.Block;
import ast.block.stmt.Statement;
import ast.expr.Expression;
import cg.CodeGenerator;
import cg.Logger;
import org.objectweb.asm.Opcodes;

public class If extends Statement {

    private Expression expr;
    private Block ifBlock;
    private Block elseBlock;

    public If(Expression expr, Block ifBlock, Block elseBlock) {
        this.expr = expr;
        this.ifBlock = ifBlock;
        this.elseBlock = elseBlock;
    }

    @Override
    public void compile() {
        Logger.log("if");
        expr.compile();
        CodeGenerator.mVisit.visitJumpInsn(Opcodes.IFEQ, ifBlock.getEnd());
        ifBlock.init();
        ifBlock.markStart();
        ifBlock.compile();
        if (elseBlock == null)
            ifBlock.markEnd();
        else {
            CodeGenerator.mVisit.visitJumpInsn(Opcodes.GOTO, elseBlock.getEnd());
            ifBlock.markEnd();
            elseBlock.init();
            elseBlock.markStart();
            elseBlock.compile();
            elseBlock.markEnd();
        }
    }

}
