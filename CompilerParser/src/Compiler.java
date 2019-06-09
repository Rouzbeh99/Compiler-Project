import java.io.FileReader;

public class Compiler {

    public static void main(String[] args) throws Exception {
        Parser parser = new Parser(new Scanner(new FileReader("input.c")));
        parser.parse();
        System.out.println("finished");
    }

}
