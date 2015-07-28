package app16;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class InputStreamReaderDemo1 {
    public static void main(String[] args) {
        Path textFile = Paths.get("C:\\temp\\myFile.txt");
        Charset chineseSimplifiedCharset =
                Charset.forName("GB2312");
        char[] chars = new char[2];
        chars[0] = '\u4F60'; // representing 你
        chars[1] = '\u597D'; // representing 好;

        // write text
        try (BufferedWriter writer =        
                Files.newBufferedWriter(textFile, 
                     chineseSimplifiedCharset, 
                     StandardOpenOption.CREATE)) {
            writer.write(chars);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        
        // read back
        try (InputStream inputStream = 
                Files.newInputStream(textFile, 
                StandardOpenOption.READ);
                
            InputStreamReader reader = new   
                    InputStreamReader(inputStream, 
                            chineseSimplifiedCharset)) {
            char[] chars2 = new char[2];
            reader.read(chars2);
            System.out.print(chars2[0]);
            System.out.print(chars2[1]);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}