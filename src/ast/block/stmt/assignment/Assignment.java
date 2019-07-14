package ast.block.stmt.assignment;

import ast.access.Access;
import ast.access.ArrayAccess;
import ast.access.StructureAccess;
import ast.access.VariableAccess;
import ast.block.BlockContent;
import ast.expr.Expression;
import ast.type.Type;
import cg.CodeGenerator;
import cg.Logger;
import org.objectweb.asm.Opcodes;
import symtab.dscp.AbstractDescriptor;

import static ast.type.Type.*;

public abstract class Assignment extends BlockContent {

    protected Access access;
    protected Expression expr;
    protected AbstractDescriptor descriptor;

    public Assignment(Access access, Expression expr) {
        this.access = access;
        this.expr = expr;
    }

    void checkOperation() {
        if (descriptor.isConst() ||
                ((access instanceof StructureAccess) && (((StructureAccess) access)).getStructureVar().isConst()))
            Logger.error("constant variables can't be changed");
    }

    public int determineOp(Type type) {
        boolean varAccess = access instanceof VariableAccess;
        if (type == DOUBLE)
            return varAccess ? Opcodes.DSTORE : Opcodes.DASTORE;
        else if (type == FLOAT)
            return varAccess ? Opcodes.FSTORE : Opcodes.FASTORE;
        else if (type == LONG)
            return varAccess ? Opcodes.LSTORE : Opcodes.LASTORE;
        else if (type == INT)
            return varAccess ? Opcodes.ISTORE : Opcodes.IASTORE;
        else
            return varAccess ? Opcodes.ASTORE : Opcodes.AASTORE;
    }

    void arrayStoreInit() {
        CodeGenerator.mVisit.visitVarInsn(Opcodes.ALOAD, descriptor.getStackIndex());
        Expression indexExpr = ((ArrayAccess) access).getIndex();
        if (indexExpr.getResultType() != INT)
            Logger.error("arrays can only be accessed using integer values");
        indexExpr.compile();
    }

}
