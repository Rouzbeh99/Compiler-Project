package symtab.dscp.function;

import ast.type.Type;

import java.util.ArrayList;
import java.util.List;

public class Functions {

    private static Functions instance = new Functions();

    private final List<FunctionDescriptor> ALL_FUNCTIONS = new ArrayList<>();

    private Functions() {
    }

    public static Functions getInstance() {
        return instance;
    }

    public void addFunction(FunctionDescriptor descriptor) {
        ALL_FUNCTIONS.add(descriptor);
    }

    public boolean contains(String id, Type... parameterTypes) {
        FunctionDescriptor temp = new FunctionDescriptor();
        temp.setName(id);
        temp.setParameterTypes(parameterTypes);
        return ALL_FUNCTIONS.contains(temp);
    }

    public boolean containsName(String id) {
        for (FunctionDescriptor function : ALL_FUNCTIONS)
            if (function.getName().equals(id))
                return true;
        return false;
    }

    public FunctionDescriptor get(String id, Type... parameterTypes) {
        FunctionDescriptor temp = new FunctionDescriptor();
        temp.setName(id);
        temp.setParameterTypes(parameterTypes);
        return ALL_FUNCTIONS.get(ALL_FUNCTIONS.indexOf(temp));
    }

}
