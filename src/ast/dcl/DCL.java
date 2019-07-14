package ast.dcl;

import ast.block.BlockContent;
import symtab.dscp.AbstractDescriptor;

public abstract class DCL extends BlockContent {

    protected AbstractDescriptor descriptor;

    public void setId(String id) {
        descriptor.setName(id);
    }

    public AbstractDescriptor getDescriptor() {
        return descriptor;
    }

}
