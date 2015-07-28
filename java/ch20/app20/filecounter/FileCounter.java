package app20.filecounter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FileCounter {
    public static void main(String[] args) {
        Path[] dirs = {
            Paths.get("C:/temp"), 
            Paths.get("C:/temp/data")
        };

        ExecutorService executorService =
                Executors.newFixedThreadPool(dirs.length);

        Future<Long>[] results = new Future[dirs.length];
        for (int i = 0; i < dirs.length; i++) {
            Path dir = dirs[i];
            FileCountTask task = new FileCountTask(dir);
            results[i] = executorService.submit(task);
        }

        // print result
        for (int i = 0; i < dirs.length; i++) {
            long fileCount = 0L;
            try {
                fileCount = results[i].get();
            } catch (InterruptedException | ExecutionException ex){
                ex.printStackTrace();
            }
            System.out.println(dirs[i] + " contains "
                    + fileCount + " files.");
        }

        // it won't exit unless we shut down the ExecutorService
        executorService.shutdownNow();
    }
}