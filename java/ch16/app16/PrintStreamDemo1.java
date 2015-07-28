package app16;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class PrintStreamDemo1 {
    public static void main(String[] args) {
        Path debugFile = Paths.get("C:\\temp\\debug.txt");
        try (OutputStream outputStream = Files.newOutputStream(
                debugFile, StandardOpenOption.CREATE, 
                StandardOpenOption.APPEND);
            PrintStream printStream = new PrintStream(outputStream, 
                    true)) {

            System.setOut(printStream);
            System.out.println("To file");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}