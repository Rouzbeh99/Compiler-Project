package ast.type;

public class CastingType extends Type {

    public static final Type CHAR = new CastingType("C");
    public static final Type INT = new CastingType("I");
    public static final Type FLOAT = new CastingType("F");
    public static final Type DOUBL = new CastingType("D");

    CastingType(String type) {
        super(type);
    }

}
