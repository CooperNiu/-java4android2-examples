package app19;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class StopThreadDemo extends JFrame {
    JLabel counterLabel = new JLabel("Counter");
    JButton startButton = new JButton("Start");
    JButton stopButton = new JButton("Stop");
    CounterThread thread = null;
    boolean stopped = false;
    int count = 1;

    class CounterThread extends Thread {
        public void run() {
            while (!stopped) {
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                }
                if (count == 1000) {
                    count = 1;
                }    
                counterLabel.setText(Integer.toString(count++));
            }
        }
    }

    public StopThreadDemo(String title) {
        super(title);
        init();
    }

    private void init() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new FlowLayout());
        this.stopButton.setEnabled(false);
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StopThreadDemo.this.startButton.setEnabled(false);
                StopThreadDemo.this.stopButton.setEnabled(true);
                startThread();
            }
        });
        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StopThreadDemo.this.startButton.setEnabled(true);
                StopThreadDemo.this.stopButton.setEnabled(false);
                stopThread();
            }
        });
        this.getContentPane().add(counterLabel);
        this.getContentPane().add(startButton);
        this.getContentPane().add(stopButton);
        this.pack();
        this.setVisible(true);
    }

    public synchronized void startThread() {
        stopped = false;
        thread = new CounterThread();
        thread.start();
    }
    
    public synchronized void stopThread() {
        stopped = true;
    }

    private static void constructGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        StopThreadDemo frame = new StopThreadDemo(
                "Stop Thread Demo");
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                constructGUI();
            }
        });
    }
}