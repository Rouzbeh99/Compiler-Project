package Nodes.Struct;
import Nodes.ClassNode;

import java.util.ArrayList;
import java.util.List;

public class StructHandler extends ClassNode {
    public static final StructHandler structHandler = new StructHandler();
    private List<Struct> Structs;
    private Struct current;

    public StructHandler() {
        Structs = new ArrayList<>();
    }

    public Struct getCurrent() {
        return current;
    }

    public void setCurrent(Struct current) {
        this.current = current;
    }
}
