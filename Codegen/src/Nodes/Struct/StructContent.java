package Nodes.Struct;

public class StructContent {
    private String type;
    private String name;
    private Object value;
    private boolean isConst;


    public StructContent(String type, String name, Object value) {
        this.type = type;
        this.name = name;
        this.value = value;
    }

    public boolean isConst() {
        return isConst;
    }

    public StructContent setConst(boolean aConst) {
        isConst = aConst;
        return this;
    }
}
