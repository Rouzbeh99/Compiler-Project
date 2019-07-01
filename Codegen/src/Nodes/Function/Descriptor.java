package Nodes.Function;

public abstract class Descriptor {
    private String name;

    public Descriptor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
