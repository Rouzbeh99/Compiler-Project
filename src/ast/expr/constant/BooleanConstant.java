package ast.expr.constant;

import ast.Node;
import ast.type.StructureType;
import ast.type.Type;
import cg.CodeGenerator;
import org.objectweb.asm.Opcodes;

public class BooleanConstant extends Constant {

    public BooleanConstant(Type type) {
        super(type);
    }

    public BooleanConstant(Object value) {
        super(value);
    }

    @Override
    public Node compile() {
        CodeGenerator.mVisit.visitInsn((Boolean) this.value ? Opcodes.ICONST_1 : Opcodes.ICONST_0);
        return new BooleanConstant(StructureType.INT);
    }

}
