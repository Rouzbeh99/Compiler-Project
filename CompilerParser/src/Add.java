import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Add {

    public static void main(String[] args) {
        try (OutputStream r = new FileOutputStream("a.class")) {
            ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_FRAMES);

            writer.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "a", null, "java/lang/Object", null);
            MethodVisitor main = writer.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC, "main", "()V", null, null);
            main.visitCode();

            main.visitMaxs(1, 1);
            main.visitEnd();

            r.write(writer.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
