package descriptor;

public class VariableDescriptor implements Descriptor {

    private int size;
    private Class type;

    public VariableDescriptor(int size, Class type) {
        this.size = size;
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public Class getType() {
        return type;
    }
    
}
