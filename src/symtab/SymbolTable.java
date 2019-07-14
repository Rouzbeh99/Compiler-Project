package symtab;

import symtab.dscp.Descriptor;
import symtab.dscp.AbstractDescriptor;

import java.util.Map;

public class SymbolTable {

    private Map<String, Descriptor> table;

    public SymbolTable(Map<String, Descriptor> table) {
        this.table = table;
    }

    public boolean contains(String id) {
        return table.containsKey(id);
    }

    public void put(AbstractDescriptor descriptor) {
        table.put(descriptor.getName(), descriptor);
    }

    public AbstractDescriptor get(String id) {
        return (AbstractDescriptor) table.get(id);
    }

}
