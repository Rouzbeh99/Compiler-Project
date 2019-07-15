package ast.block;

import ast.Node;
import cg.CodeGenerator;
import org.objectweb.asm.Label;
import symtab.SymbolTable;
import symtab.TableStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Block implements Node {

    private Label start = new Label();
    private Label end = new Label();
    private List<BlockContent> contents = new ArrayList<>();

    public Block() {
        Blocks.getInstance().add(this);
    }

    public Label getStart() {
        return start;
    }

    public Label getEnd() {
        return end;
    }

    public void addContent(BlockContent content) {
        contents.add(content);
    }

    public void init() {
        TableStack.getInstance().pushSymbolTable(new SymbolTable(new HashMap<>()));
    }

    public void markStart() {
        CodeGenerator.mVisit.visitLabel(start);
    }

    @Override
    public void compile() {
        contents.forEach(Node::compile);
    }

    public void markEnd() {
        CodeGenerator.mVisit.visitLabel(end);
        TableStack.getInstance().popSymbolTable();
    }

}
