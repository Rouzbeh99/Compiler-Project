package Nodes;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

public abstract class ClassNode {
    ClassWriter classWriter;
    ClassVisitor classVisitor;
    public abstract ClassNode compile();
}
