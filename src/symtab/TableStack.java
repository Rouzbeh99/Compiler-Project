package symtab;

import ast.type.Type;
import cg.Logger;
import symtab.dscp.AbstractDescriptor;
import symtab.dscp.KeywordDescriptor;
import symtab.dscp.function.FunctionDescriptor;
import symtab.dscp.function.Functions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static ast.type.Type.DOUBLE;
import static ast.type.Type.LONG;

public class TableStack {

    private static final TableStack instance = new TableStack();
    private final List<SymbolTable> SYM_TAB_STACK = new ArrayList<>();
    private final SymbolTable GLOBALS;
    private FunctionDescriptor currentFunection;
    private int stackIndex;

    private final String[] KEYWORDS = {
            "const",
            "record",
            "bool",
            "char",
            "int",
            "long",
            "float",
            "double",
            "string",
            "void",
            "true",
            "false",
            "extern",
            "auto",
            "function",
            "begin",
            "end",
            "if",
            "else",
            "switch",
            "of",
            "case",
            "default",
            "for",
            "foreach",
            "in",
            "repeat",
            "until",
            "break",
            "continue",
            "return",
            "sizeof",
            ";",
            ":",
            ",",
            ".",
            "~",
            "+",
            "-",
            "*",
            "/",
            "%",
            "=",
            "&",
            "|",
            "^",
            "not",
            "and",
            "or",
            "<",
            ">",
            "{",
            "}",
            "[",
            "]",
            "(",
            ")",
            "++",
            "--",
            "+=",
            "-=",
            "*=",
            "/=",
            "!=",
            "==",
            "<=",
            ">="};

    {
        GLOBALS = new SymbolTable(Arrays.stream(KEYWORDS).collect(Collectors.toMap(key -> key, key -> new KeywordDescriptor())));
    }

    private TableStack() {
    }

    public static TableStack getInstance() {
        return instance;
    }

    private SymbolTable getTop() {
        return SYM_TAB_STACK.get(SYM_TAB_STACK.size() - 1);
    }

    public FunctionDescriptor currentFunction() {
        return currentFunection;
    }

    public void pushSymbolTable(SymbolTable symbolTable) {
        SYM_TAB_STACK.add(symbolTable);
    }

    public void popSymbolTable() {
        SYM_TAB_STACK.remove(SYM_TAB_STACK.size() - 1);
    }

    public void addGlobal(AbstractDescriptor descriptor) {
        GLOBALS.put(descriptor);
    }

    public void newFunction(FunctionDescriptor descriptor, boolean isMain) {
        stackIndex = isMain ? 1 : 0;
        currentFunection = descriptor;
        descriptor.getParameters().forEach(this::addVariable);
    }

    public void addVariable(AbstractDescriptor descriptor) {
        if (getTop().contains(descriptor.getName()) ||
                Functions.getInstance().containsName(descriptor.getName()))
            Logger.error("variable name already exists");
        descriptor.setStackIndex(stackIndex);
        Type type = descriptor.getType();
        stackIndex += type == LONG || type == DOUBLE ? 2 : 1;
        getTop().put(descriptor);
    }

    public AbstractDescriptor find(String id) {
        for (int i = SYM_TAB_STACK.size() - 1; i >= 0; i--) {
            SymbolTable table = SYM_TAB_STACK.get(i);
            if (table.contains(id))
                return table.get(id);
        }
        return GLOBALS.contains(id) ? GLOBALS.get(id) : null;
    }

}
