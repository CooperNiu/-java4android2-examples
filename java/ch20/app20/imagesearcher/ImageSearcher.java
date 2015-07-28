package app20.imagesearcher;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class ImageSearcher extends JFrame 
        implements ActionListener {
    public static final int MAX_RESULT = 300;
    JButton searchButton = new JButton("Search");
    DefaultListModel listModel;
    JList imageList;
    Executor executor = Executors.newFixedThreadPool(10);
    AtomicInteger fileCounter = new AtomicInteger(1);
    
    public ImageSearcher(String title) {
        super(title);
        init();
    }

    private void init() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.add(searchButton, BorderLayout.NORTH);
        listModel = new DefaultListModel();
        imageList = new JList(listModel);
        this.add(new JScrollPane(imageList), BorderLayout.CENTER);
        this.pack();
        this.setSize(800, 650);
        searchButton.addActionListener(this);
        this.setVisible(true);
        // center frame
        this.setLocationRelativeTo(null);
    }

    private static void constructGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        ImageSearcher frame = new ImageSearcher("Image Searcher");
    }
    
    public void actionPerformed(ActionEvent e) {
        Iterable<Path> roots = 
                FileSystems.getDefault().getRootDirectories();
        for (Path root : roots) {
            executor.execute(new ImageSearchTask(root, executor, 
                    listModel, fileCounter));
        }
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                constructGUI();
            }
        });
    }
}
