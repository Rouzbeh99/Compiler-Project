package Nodes.Struct;
import Nodes.ClassNode;

import java.util.ArrayList;
import java.util.List;

public class StructHandler extends ClassNode {
    public static final StructHandler structHandler = new StructHandler();
    private List<Struct> allStructs;
    private Struct current;

    public StructHandler() {
        allStructs = new ArrayList<>();
    }

    public void addtoStructs(Struct struct){
        allStructs.add(struct);
    }

    public Struct getStruct(String name){
        for (Struct struct : allStructs) {
            if(struct.getName().equals(name))
                return struct;
        }
        return null;
    }

    public Struct getCurrent() {
        return current;
    }

    public void setCurrent(Struct current) {
        this.current = current;
    }

    @Override
    public ClassNode compile() {
        return null;
    }
}
