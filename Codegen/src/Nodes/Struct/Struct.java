package Nodes.Struct;

import java.util.ArrayList;
import java.util.List;

public class Struct {
    private List<Struct> allStructs;
    private String name;
    private List<StructContent> contents;

    public Struct( String name) {
        this.allStructs = new ArrayList<>();
        this.name = name;
        StructHandler.structHandler.setCurrent(this);
    }


}
