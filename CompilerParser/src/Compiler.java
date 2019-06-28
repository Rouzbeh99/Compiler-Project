import soot.util.backend.SootASMClassWriter;

public class Compiler {

    public static void main(String[] args) throws Exception {


        SootASMClassWriter writer = new SootASMClassWriter(10);
        System.out.println(writer.newClass("Test"));
//        Parser parser = new Parser(new Scanner(new FileReader("input.c")));
//        parser.parse();
//        System.out.println("finished");
    }

}
