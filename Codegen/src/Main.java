import Nodes.ConstNodes.ExpressionNode;
import Nodes.ConstNodes.IntConstNode;
import Nodes.Operations.Binary.Add;
import Nodes.Operations.Binary.Mult;

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

        ExpressionNode expressionNode = new ExpressionNode();
        expressionNode.compile();
    }

}
