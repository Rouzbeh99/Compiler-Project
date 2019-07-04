package ast.dcl.variable;

import ast.Node;
import ast.block.BlockContent;

import java.util.List;

public class VariableDcl extends BlockContent {

    private List<LocalVariableDCL> dcls;

    public VariableDcl(List<LocalVariableDCL> dcls) {
        this.dcls = dcls;
    }

    @Override
    public Node compile() {
        dcls.forEach(LocalVariableDCL::compile);
        return null;
    }

}
