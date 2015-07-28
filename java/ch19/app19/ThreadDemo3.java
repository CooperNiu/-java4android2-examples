package app19;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ThreadDemo3 extends JFrame {
    JLabel countUpLabel = new JLabel("Count Up");
    JLabel countDownLabel = new JLabel("Count Down");

    class CountUpThread extends Thread {
        public void run() {
            int count = 1000;
            while (true) {
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                }
                if (count == 0)
                    count = 1000;
                countUpLabel.setText(Integer.toString(count--));
            }
        }
    }

    class CountDownThread extends Thread {
        public void run() {
            int count = 0;
            while (true) {
                try {
                    sleep(50);
                } catch (InterruptedException e) {
                }
                if (count == 1000)
                    count = 0;
                countDownLabel.setText(Integer.toString(count++));
            }
        }
    }
    public ThreadDemo3(String title) {
        super(title);
        init();
    }

    private void init() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new FlowLayout());
        this.add(countUpLabel);
        this.add(countDownLabel);
        this.pack();
        this.setVisible(true);
        new CountUpThread().start();
        new CountDownThread().start();
    }

    private static void constructGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        ThreadDemo3 frame = new ThreadDemo3("Thread Demo 3");
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                constructGUI();
            }
        });
    }
}