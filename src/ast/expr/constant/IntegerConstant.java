package ast.expr.constant;

import ast.Node;
import ast.type.StructureType;
import ast.type.Type;

public class IntegerConstant extends Constant {

    public IntegerConstant(Type type) {
        super(type);
    }

    public IntegerConstant(Object value) {
        super(value);
    }

    @Override
    public Node compile() {
        super.compile();
        return new IntegerConstant(StructureType.INT);
    }

}
