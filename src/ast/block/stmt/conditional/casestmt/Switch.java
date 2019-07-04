package ast.block.stmt.conditional.casestmt;

import ast.Node;
import ast.block.Block;
import ast.block.stmt.Statement;
import ast.type.TypeChecker;
import cg.CodeGenerator;
import cg.Logger;
import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;
import symtab.TableStack;
import symtab.dscp.VariableDescriptor;

import java.util.List;

public class Switch extends Statement {

    private String id;
    private Block defaultBlock;

    public Switch(String id, Block defaultBlock) {
        this.id = id;
        this.defaultBlock = defaultBlock;
    }

    @Override
    public Node compile() {
        Logger.log("switch-case");
        Cases cs = Cases.getInstance();
        Label defaultLabel = defaultBlock.getStart();
        VariableDescriptor descriptor = TableStack.getInstance().findVariable(id);
        if (!TypeChecker.isValidSwitchType(descriptor.getType()))
            Logger.error("invalid switch type");
        CodeGenerator.mVisit.visitVarInsn(Opcodes.ILOAD, descriptor.getStackIndex());
        CodeGenerator.mVisit.visitTableSwitchInsn(cs.getMin(), cs.getMax(), defaultLabel, cs.getLabels(defaultLabel));

        Label endCase = defaultBlock.getEnd();
        List<Block> caseBlocks = cs.getCaseBlocks();
        for (Block block : caseBlocks) {
            block.markStart();
            block.compile();
            CodeGenerator.mVisit.visitJumpInsn(Opcodes.GOTO, endCase);
            block.markEnd();
        }

        defaultBlock.markStart();
        defaultBlock.compile();
        CodeGenerator.mVisit.visitJumpInsn(Opcodes.GOTO, endCase);
        defaultBlock.markEnd();

        return this;
    }

}
