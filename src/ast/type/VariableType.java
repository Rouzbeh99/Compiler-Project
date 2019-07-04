package ast.type;

public class VariableType extends StructureType {

    public static final Type STRING = new VariableType("Ljava/lang/String");

    public VariableType(String type) {
        super(type);
    }

}
