package cg;

import org.objectweb.asm.*;
import org.objectweb.asm.util.ASMifier;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import static org.objectweb.asm.Opcodes.*;

public class CodeGenerator {

    public static final String OUTPUT_FILE = "Compiled.class";

    public static ClassWriter clWriter;
    public static MethodVisitor mVisit;
    public static FieldVisitor fVisit;


    public static void main(String[] args) throws IOException {
        ASMifier.main(new String[]{"A.class"});
//        initClass();
//        writeFinalClassCode();
    }


    public static void initClass() {
        Logger.log("Initializing code generator");

        clWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        clWriter.visit(V1_8, ACC_PUBLIC, "Compiled", null, "java/lang/Object", null);
        mVisit = clWriter.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
        mVisit.visitCode();
        mVisit.visitVarInsn(ALOAD, 0);
        mVisit.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        mVisit.visitInsn(RETURN);
        mVisit.visitMaxs(1, 1);
        mVisit.visitEnd();
        mVisit = clWriter.visitMethod(ACC_PUBLIC | ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
        Label dl = new Label();
        Label l1 = new Label();
        Label l2 = new Label();
        Label l3 = new Label();
        Label l4 = new Label();
        mVisit.visitLookupSwitchInsn(dl, new int[]{2, 1, 7, 4}, new Label[]{l1, l2, l3, l4});
        mVisit.visitLabel(l1);
        mVisit.visitInsn(NOP);
        mVisit.visitLabel(l2);
        mVisit.visitInsn(NOP);
        mVisit.visitLabel(l3);
        mVisit.visitInsn(NOP);
        mVisit.visitLabel(l4);
        mVisit.visitInsn(NOP);
        mVisit.visitLabel(dl);
        mVisit.visitInsn(NOP);
        mVisit.visitCode();
        mVisit.visitEnd();
    }

    public static Label putLabel() {
        Label label = new Label();
        mVisit.visitLabel(label);
        return label;
    }

    public static void writeFinalClassCode() throws IOException {
        Logger.log("Writing the generated code into the executable output file");

        clWriter.visitEnd();
        try (OutputStream out = new FileOutputStream(OUTPUT_FILE)) {
            out.write(clWriter.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Logger.log("Code generation finished");
        Logger.close();
    }

}
