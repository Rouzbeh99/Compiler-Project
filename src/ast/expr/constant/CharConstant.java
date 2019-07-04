package ast.expr.constant;

import ast.Node;
import ast.type.StructureType;
import ast.type.Type;

public class CharConstant extends Constant {

    public CharConstant(Type type) {
        super(type);
    }

    public CharConstant(Object value) {
        super(value);
        StringBuilder literal = (StringBuilder) value;
        literal.deleteCharAt(0);
        literal.deleteCharAt(literal.length() - 1);
        this.value = literal.charAt(0);
    }

    @Override
    public Node compile() {
        super.compile();
        return new CharConstant(StructureType.INT);
    }

}
