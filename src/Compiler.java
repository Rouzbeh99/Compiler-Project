import ast.program.Program;

import java.io.FileReader;

public class Compiler {

    private static final String INPUT_FILE = "codegen.txt";

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new FileReader(INPUT_FILE));
        Parser parser = new Parser(scanner);
        parser.parse();
        Program.getInstance().compile();
    }

}
