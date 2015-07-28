package app20.imagesearcher;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;

public class ImageSearchTask implements Runnable {
    private Path searchDir;
    private Executor executor;
    private DefaultListModel listModel;
    private AtomicInteger fileCounter;

    public ImageSearchTask(Path searchDir, Executor executor, DefaultListModel listModel,
            AtomicInteger fileCounter) {
        this.searchDir = searchDir;
        this.executor = executor;
        this.listModel = listModel;
        this.fileCounter = fileCounter;
    }

    @Override
    public void run() {
        if (fileCounter.get() > ImageSearcher.MAX_RESULT) {
            return;
        }
        try (DirectoryStream<Path> children = 
                Files.newDirectoryStream(searchDir)) {
            for (final Path child : children) {
                if (Files.isDirectory(child)) {
                    executor.execute(new ImageSearchTask(child, 
                            executor, listModel, fileCounter));
                } else if (Files.isRegularFile(child)) {
                    String name = child.getFileName()
                            .toString().toLowerCase();
                    if (name.endsWith(".jpg")) {
                        final int fileNumber = 
                                fileCounter.getAndIncrement();
                        if (fileNumber > ImageSearcher.MAX_RESULT){
                            break;
                        }

                        SwingUtilities.invokeLater(new Runnable() {
                            public void run() {
                                listModel.addElement(fileNumber + 
                                        ": " + child);
                            }
                        });
                    }
                }
            }            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}