package app16;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class PrintWriterDemo1 {
    public static void main(String[] args) {
        Path path = Paths.get("c:\\temp\\printWriterOutput.txt");
        Charset usAsciiCharset = Charset.forName("US-ASCII");
        try (BufferedWriter bufferedWriter = 
                Files.newBufferedWriter(path, usAsciiCharset, 
                StandardOpenOption.CREATE);
            PrintWriter printWriter = 
                    new PrintWriter(bufferedWriter)) {
            printWriter.println("PrintWriter is easy to use.");
            printWriter.println(1234);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}