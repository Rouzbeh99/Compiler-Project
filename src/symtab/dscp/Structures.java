package symtab.dscp;

import cg.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Structures {

    private static final Structures instance = new Structures();

    final List<StructureDescriptor> ALL_STRUCTURE_TYPES = new ArrayList<>();

    private Structures() {
    }

    public static Structures getInstance() {
        return instance;
    }

    public boolean typeExists(String typeName) {
        for (StructureDescriptor type : ALL_STRUCTURE_TYPES)
            if (type.getName().equals(typeName))
                return true;
        return false;
    }

    public StructureDescriptor newDescriptor(String name) {
        for (StructureDescriptor type : ALL_STRUCTURE_TYPES) {
            if (type.getName().equals(name)) {
                List<VariableDescriptor> temp = type.getVariables().entrySet()
                        .stream().map(e -> e.getValue().clone()).collect(Collectors.toList());
                return new StructureDescriptor(name, temp);
            }
        }
        Logger.error("type not found");
        return null;
    }

}
