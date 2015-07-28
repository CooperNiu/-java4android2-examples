package app16;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class OutputStreamDemo1 {
    public void copyFiles(Path originPath, Path destinationPath)
            throws IOException {
        if (Files.notExists(originPath) 
                || Files.exists(destinationPath)) {
            throw new IOException(
                    "Origin file must exist and " + 
                    "Destination file must not exist");
        }
        byte[] readData = new byte[1024];
        try (InputStream inputStream =
                    Files.newInputStream(originPath, 
                    StandardOpenOption.READ);
            OutputStream outputStream = 
                    Files.newOutputStream(destinationPath, 
                    StandardOpenOption.CREATE)) {
            int i = inputStream.read(readData);
            while (i != -1) {
                outputStream.write(readData, 0, i);
                i = inputStream.read(readData);
            }
        } catch (IOException e) {
            throw e;
        }
    }

    public static void main(String[] args) {
        OutputStreamDemo1 test = new OutputStreamDemo1();
        Path origin = Paths.get("C:\\temp\\line1.bmp");
        Path destination = Paths.get("C:\\temp\\line3.bmp");
        try {
            test.copyFiles(origin, destination);
            System.out.println("Copied Successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}