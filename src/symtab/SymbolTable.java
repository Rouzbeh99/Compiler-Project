package symtab;

import symtab.dscp.Descriptor;
import symtab.dscp.VariableDescriptor;

import java.util.Map;

public class SymbolTable {

    private Map<String, Descriptor> table;

    public SymbolTable(Map<String, Descriptor> table) {
        this.table = table;
    }

    public boolean contains(String id) {
        return table.containsKey(id);
    }

    public void put(VariableDescriptor descriptor) {
        table.put(descriptor.getName(), descriptor);
    }

    public VariableDescriptor get(String id) {
        return (VariableDescriptor) table.get(id);
    }

}
