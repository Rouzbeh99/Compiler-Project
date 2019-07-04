package symtab.dscp;

import cg.Logger;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StructureDescriptor implements Descriptor {

    private String name;
    private Map<String, VariableDescriptor> variables;

    public StructureDescriptor(String name, List<VariableDescriptor> variables) {
        if (Structures.getInstance().typeExists(name))
            Logger.error("type already exists");
        this.name = name;
        this.variables = variables.stream().collect(Collectors.toMap(VariableDescriptor::getName, dscp -> dscp));
        Structures.getInstance().ALL_STRUCTURE_TYPES.add(this);
    }

    public String getName() {
        return name;
    }

    public Map<String, VariableDescriptor> getVariables() {
        return variables;
    }

}
