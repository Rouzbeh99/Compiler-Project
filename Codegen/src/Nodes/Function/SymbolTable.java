package Nodes.Function;

import Nodes.ClassNode;

import java.util.ArrayList;
import java.util.List;

public class SymbolTable  {
    private List<Descriptor> allAescriptors;

    public SymbolTable() {
        this.allAescriptors = new ArrayList<>();
    }

    public void addToSymtab(Descriptor descriptor){
        allAescriptors.add(descriptor);
    }
}
