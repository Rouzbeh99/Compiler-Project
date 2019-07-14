package ast.program.function;

import ast.type.Type;
import symtab.dscp.variable.VariableDescriptor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FunctionArguments {

    private static final FunctionArguments instance = new FunctionArguments();

    private List<VariableDescriptor> arguments;

    private FunctionArguments() {
    }

    public static FunctionArguments getInstance() {
        return instance;
    }

    public void init() {
        arguments = new ArrayList<>();
    }

    public List<VariableDescriptor> getArguments() {
        Collections.reverse(arguments);
        return arguments;
    }

    public void addArgument(String id, Type type) {
        VariableDescriptor descriptor = new VariableDescriptor();
        descriptor.setName(id);
        descriptor.setType(type);
        descriptor.setConst(false);
        arguments.add(descriptor);
    }

}
