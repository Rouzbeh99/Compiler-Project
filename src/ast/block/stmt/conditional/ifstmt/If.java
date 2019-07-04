package ast.block.stmt.conditional.ifstmt;

import ast.Node;
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
    public Node compile() {
        Logger.log("if");

        expr.compile();
        CodeGenerator.mVisit.visitJumpInsn(Opcodes.IFEQ, ifBlock.getEnd());
        ifBlock.compile();
        if (elseBlock == null)
            ifBlock.markEnd();
        else {
            CodeGenerator.mVisit.visitJumpInsn(Opcodes.GOTO, elseBlock.getEnd());
            ifBlock.markEnd();
            elseBlock.compile();
            elseBlock.markEnd();
        }
        return this;
    }

}
