package app16;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class InputStreamDemo1 {
    public boolean compareFiles(Path path1, Path path2) 
            throws NoSuchFileException {
        
        if (Files.notExists(path1)) {
            throw new NoSuchFileException(path1.toString());
        }
        if (Files.notExists(path2)) {
            throw new NoSuchFileException(path2.toString());
        }
        try {
            if (Files.size(path1) != Files.size(path2)) {
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (InputStream inputStream1 = Files.newInputStream(
                    path1, StandardOpenOption.READ);
            InputStream inputStream2 = Files.newInputStream(
                    path2, StandardOpenOption.READ)) {
            
            int i1, i2;
            do {
                i1 = inputStream1.read();
                i2 = inputStream2.read();
                if (i1 != i2) {
                    return false;
                }
            } while (i1 != -1);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Path path1 = Paths.get("C:\\temp\\line1.bmp");
        Path path2 = Paths.get("C:\\temp\\line2.bmp");
        InputStreamDemo1 test = new InputStreamDemo1();
        try {
            if (test.compareFiles(path1, path2)) {
                System.out.println("Files are identical");
            } else {
                System.out.println("Files are not identical");
            }
        } catch (NoSuchFileException e) {
            e.printStackTrace();
        }
        
        // the compareFiles method is not the same as 
        // Files.isSameFile
        try {
            System.out.println(Files.isSameFile(path1, path2));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}