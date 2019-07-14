package cg;

import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    private static final String LOG_FILE = "log.txt";
    private static FileWriter writer;

    static {
        init();
    }

    private static void init() {
        try {
            writer = new FileWriter(LOG_FILE);
            writer.write("");
            writer.flush();
            writer.close();
            writer = new FileWriter(LOG_FILE, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void log(String log) {
        try {
            log = log + System.lineSeparator();
            System.out.println(log);
            writer.write(log);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void error(String error) {
        error = "(Error) " + error;
        Logger.log(error);
        throw new RuntimeException();
    }

    public static void close() throws IOException {
        writer.close();
    }

}
