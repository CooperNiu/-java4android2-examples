package app16;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class OutputStreamWriterDemo1 {
    public static void main(String[] args) {
        char[] chars = new char[2];
        chars[0] = '\u4F60'; // representing 你
        chars[1] = '\u597D'; // representing 好;
        Path path = Paths.get("C:\\temp\\myFile.txt");
        Charset chineseSimplifiedCharset = 
                Charset.forName("GB2312");

        try (OutputStream outputStream = 
                Files.newOutputStream(path, 
                StandardOpenOption.CREATE);
            OutputStreamWriter writer = new OutputStreamWriter(
                    outputStream, chineseSimplifiedCharset)) {
            
            writer.write(chars);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}