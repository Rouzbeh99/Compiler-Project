package ast.program;

import ast.Node;
import ast.type.Type;
import cg.CodeGenerator;
import cg.Logger;
import symtab.dscp.function.Functions;

import java.util.ArrayList;
import java.util.List;

public class Program implements Node {

    private static final Program instance = new Program();

    private List<ProgramContent> contents = new ArrayList<>();

    private Program() {
    }

    public static Program getInstance() {
        return instance;
    }

    public void addContent(ProgramContent content) {
        contents.add(content);
    }

    @Override
    public void compile() {
        Logger.log("compiling program");
        CodeGenerator.initClass();
        contents.forEach(ProgramContent::compile);
        checkMainExistence();
        CodeGenerator.writeFinalClassCode();
    }

    private void checkMainExistence() {
        if (!Functions.getInstance().contains("main") ||
                Functions.getInstance().get("main").getReturnType() != Type.INT ||
                !Functions.getInstance().get("main").isCompleteDCL())
            Logger.error("program doesn't contain a main function");
    }

}
