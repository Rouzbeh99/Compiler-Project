import Nodes.DCL.Type;
import Nodes.ExpressionNodes.Block;
import Nodes.ExpressionNodes.*;
import Nodes.Operations.Binary.*;
import Nodes.DCL.VariableNode;
public class Main {

    public static void main(String[] args) {
//        try (OutputStream r = new FileOutputStream("a.class")) {
//            ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
//
//            writer.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "a", null, "java/lang/Object", null);
//            MethodVisitor main = writer.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC, "main", "()V", null, null);
//            main.visitCode();
//
//            main.visitMaxs(1, 1);
//            main.visitEnd();
//
//            r.write(writer.toByteArray());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    Block block = new Block();
    block.addToBlock(new Add
            (new Div(new IntConstNode(23),new VariableCall("sgd")),new IntConstNode(34))));


    }

}
