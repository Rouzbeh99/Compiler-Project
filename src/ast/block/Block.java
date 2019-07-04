package ast.block;

import ast.Node;
import cg.CodeGenerator;
import org.objectweb.asm.Label;
import symtab.SymbolTable;
import symtab.TableStack;

import java.util.HashMap;
import java.util.List;

public class Block implements Node {

    private Label start = new Label();
    private Label end = new Label();
    private List<BlockContent> contents;

    public Block() {
        Blocks.getInstance().add(this);
        TableStack.getInstance().pushSymbolTable(new SymbolTable(new HashMap<>()));
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

    public void markStart() {
        CodeGenerator.mVisit.visitLabel(start);
    }

    @Override
    public Node compile() {
        contents.forEach(Node::compile);
        return null;
    }

    public void markEnd() {
        CodeGenerator.mVisit.visitLabel(end);
        Blocks.getInstance().remove();
        TableStack.getInstance().popSymbolTable();
    }

}
