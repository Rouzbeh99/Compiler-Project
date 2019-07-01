package Nodes.Struct;

public class StructContent {
    private String type;
    private String name;
    private Object value;
    private boolean isConst;


    public StructContent(String type, String name, Object value, boolean isConst) {
        this.type = type;
        this.name = name;
        this.value = value;
        this.isConst = isConst;
    }
}
