package descriptor;

import java.util.HashMap;
import java.util.Map;

public class StructureDescriptor implements Descriptor {

    private Map<String, VariableDescriptor> variables = new HashMap<>();

    public void addVariable(int size, Class type, String id) {
        if (variables.containsKey(id))
            throw new RuntimeException();
        variables.put(id, new VariableDescriptor(size, type));
    }

    
}
