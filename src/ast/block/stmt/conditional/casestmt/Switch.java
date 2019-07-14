package ast.block.stmt.conditional.casestmt;

import ast.access.Access;
import ast.access.ArrayAccess;
import ast.access.StructureAccess;
import ast.block.Block;
import ast.block.stmt.Statement;
import ast.type.Type;
import ast.type.TypeChecker;
import cg.Logger;
import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;
import symtab.dscp.array.ArrayDescriptor;
import symtab.dscp.variable.VariableDescriptor;

import java.util.List;

import static cg.CodeGenerator.mVisit;

public class Switch extends Statement {

    private Access access;
    private Block defaultBlock;

    public Switch(Access access, Block defaultBlock) {
        this.access = access;
        this.defaultBlock = defaultBlock;
    }

    @Override
    public void compile() {
        Logger.log("switch-case");
        checkOperation();

        Cases cs = Cases.getInstance();
        Label defaultLabel = defaultBlock.getStart();
        access.compile();
        mVisit.visitTableSwitchInsn(cs.getMin(), cs.getMax(), defaultLabel, cs.getLabels(defaultLabel));
        Label endCase = defaultBlock.getEnd();

        List<Block> caseBlocks = cs.getCaseBlocks();
        for (Block block : caseBlocks) {
            block.init();
            block.markStart();
            block.compile();
            mVisit.visitJumpInsn(Opcodes.GOTO, endCase);
            block.markEnd();
        }
        defaultBlock.init();
        defaultBlock.markStart();
        defaultBlock.compile();
        defaultBlock.markEnd();
    }

    private void checkOperation() {
        Type switchType;
        if (access instanceof StructureAccess)
            switchType = ((StructureAccess) access.getDescriptor()).getStructureVar().getType();
        else if (access instanceof ArrayAccess)
            switchType = Type.toSimple(((ArrayDescriptor) access.getDescriptor()).getType());
        else
            switchType = ((VariableDescriptor) access.getDescriptor()).getType();
        if (!TypeChecker.isValidSwitchType(switchType))
            Logger.error("invalid switch type");
    }

}
