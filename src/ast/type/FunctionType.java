package ast.type;

public class FunctionType extends VariableType {

    public static final Type VOID = new FunctionType("V");

    FunctionType(String type) {
        super(type);
    }

}
