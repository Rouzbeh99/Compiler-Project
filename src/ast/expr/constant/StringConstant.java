package ast.expr.constant;

import ast.Node;
import ast.type.Type;
import ast.type.VariableType;

public class StringConstant extends Constant {

    public StringConstant(Type type) {
        super(type);
    }

    public StringConstant(Object value) {
        super(value);
    }

    @Override
    public Node compile() {
        super.compile();
        return new StringConstant(VariableType.STRING);
    }

}
