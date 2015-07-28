package app19;
public class RunnableDemo1 implements Runnable {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }

    public static void main(String[] args) {
        RunnableDemo1 demo = new RunnableDemo1();
        Thread thread = new Thread(demo);
        thread.start();
    }
}