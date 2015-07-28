package app19;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ThreadPriorityDemo extends JFrame {
    JLabel counter1Label = new JLabel("Priority 10");
    JLabel counter2Label = new JLabel("Priority 1");

    class CounterThread extends Thread {
        JLabel counterLabel;
        public CounterThread(JLabel counterLabel) {
            super();
            this.counterLabel = counterLabel;
        }

        public void run() {
            int count = 0;
            while (true) {
                try {
                    sleep(1);
                } catch (InterruptedException e) {
                }
                if (count == 50000)
                    count = 0;
                counterLabel.setText(Integer.toString(count++));
            }
        }
    }

    public ThreadPriorityDemo(String title) {
        super(title);
        init();
    }

    private void init() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.add(counter1Label);
        this.add(counter2Label);
        this.pack();
        this.setVisible(true);
        CounterThread thread1 = new CounterThread(counter1Label);
        thread1.setPriority(10);
        CounterThread thread2 = new CounterThread(counter2Label);
        thread2.setPriority(1);
        thread2.start();
        thread1.start();
    }

    private static void constructGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        ThreadPriorityDemo frame = new ThreadPriorityDemo(
                "Thread Priority Demo");
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                constructGUI();
            }
        });
    }
}