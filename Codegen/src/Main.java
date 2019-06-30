import Nodes.ExpressionNodes.IntConstNode;
import Nodes.DCL.Type;
import Nodes.DCL.VariableNode;
import Nodes.Operations.Binary.Add;
import Nodes.Operations.Binary.Assignment;
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

        new Assignment(new Add(new Mult(new IntConstNode(9 ), new IntConstNode(34))
                ,new IntConstNode(2)),new VariableNode("name",new Type("int"),false)).compile();

    }

}
