package ast.type;

public class StructureType extends CastingType {

    public static final Type BOOL = new StructureType("Z");
    public static final Type LONG = new StructureType("J");
    public static final Type AUTO = new StructureType("A");

    StructureType(String type) {
        super(type);
    }

}
