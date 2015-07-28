package app20.filecounter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class FileCountTask implements Callable {
    Path dir;
    long fileCount = 0L;
    public FileCountTask(Path dir) {
        this.dir = dir;
    }

    private void doCount(Path parent) {
        if (Files.notExists(parent)) {
            return;
        }
        try (DirectoryStream<Path> children = 
                    Files.newDirectoryStream(parent)) {
            for (Path child : children) {
                if (Files.isDirectory(child)) {
                    doCount(child);
                } else if (Files.isRegularFile(child)) {
                    fileCount++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Long call() throws Exception {
        System.out.println("Start counting " + dir);
        doCount(dir);
        System.out.println("Finished counting " + dir);
        return fileCount;
    }
}