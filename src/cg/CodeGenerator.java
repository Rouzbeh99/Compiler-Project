package cg;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import static org.objectweb.asm.Opcodes.*;

public class CodeGenerator {

    private static final String OUTPUT_FILE = "Compiled.class";
    public static final String SUPER_CLASS = "java/lang/Object";
    public static final String GENERATED_CLASS = "Compiled";

    public static ClassWriter mainClw;
    public static ClassWriter structClw;
    public static MethodVisitor mVisit;

    public static void initClass() {
        Logger.log("Initializing code generator");
        mainClw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        mainClw.visit(V1_8, ACC_PUBLIC, GENERATED_CLASS, null, SUPER_CLASS, null);
        mVisit = mainClw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
        mVisit.visitCode();
        mVisit.visitVarInsn(ALOAD, 0);
        mVisit.visitMethodInsn(INVOKESPECIAL, SUPER_CLASS, "<init>", "()V", false);
        mVisit.visitInsn(RETURN);
        mVisit.visitMaxs(1, 1);
        mVisit.visitEnd();
    }

    public static void writeFinalClassCode() {
        Logger.log("Writing the generated code into the executable output file");
        mainClw.visitEnd();
        try (OutputStream out = new FileOutputStream(OUTPUT_FILE)) {
            out.write(mainClw.toByteArray());
            Logger.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeStructureClassCode(String outputFile) {
        Logger.log("writing structures class code to the output file");
        try (OutputStream out = new FileOutputStream(outputFile)) {
            out.write(structClw.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
