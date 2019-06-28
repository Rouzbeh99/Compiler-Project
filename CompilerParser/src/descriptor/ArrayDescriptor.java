package descriptor;

public class ArrayDescriptor implements Descriptor {

    int size;
    int baseAddress;
    Class type;

    public ArrayDescriptor(int size, int baseAddress, Class type) {
        this.size = size;
        this.baseAddress = baseAddress;
        this.type = type;
    }

}
