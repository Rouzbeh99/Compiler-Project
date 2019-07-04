package ast.expr.constant;

import ast.Node;
import ast.type.StructureType;
import ast.type.Type;

public class DoubleConstant extends Constant {

    public DoubleConstant(Type type) {
        super(type);
    }

    public DoubleConstant(Object value) {
        super(value);
    }

    @Override
    public Node compile() {
        super.compile();
        return new DoubleConstant(StructureType.DOUBL);
    }

}
